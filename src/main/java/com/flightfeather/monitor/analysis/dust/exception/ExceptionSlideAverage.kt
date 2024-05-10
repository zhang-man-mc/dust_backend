package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.enumration.dust.DataStatus
import com.flightfeather.monitor.enumration.dust.ExceptionType
import kotlin.math.abs

/**
 * 滑动平均值突变异常
 */
class ExceptionSlideAverage(config: DustExceptionSetting) : BaseDustExceptionAnalysis(config) {

    private val historyDataList = mutableListOf<DustSiteData>()
    private val tempDataList = mutableListOf<DustSiteData>()
    private val avgListReverse = mutableListOf<Pair<Double, Boolean>>()
    private var startData: DustSiteData? = null
    private var lastData: DustSiteData? = null
    private var sIndex = 0
    private var eIndex = -1
    private var existException = false

    override fun init() {
        super.init()
        historyDataList.clear()
        tempDataList.clear()
        avgListReverse.clear()
        startData = null
        lastData = null
        sIndex = 0
        eIndex = -1
        existException = false
    }

    override fun getExceptionType(): ExceptionType = ExceptionType.TYPE7

    override fun onNextData(data: DustSiteData) {
        eIndex++
        if (startData == null) {
            startData = data
        }
        historyDataList.add(data)

        // 数据加入临时数组
        tempDataList.add(data)
        // 数据量超出设置数量时，去除当前数据组首个数据
        if (tempDataList.size > config.changeTrendGroup) {
            tempDataList.removeAt(0)
        }
        // 数据量等于设置数量时，计算当前数据组均值
        if (tempDataList.size == config.changeTrendGroup) {
            calAvg(tempDataList)
            if (checkSlideAvg()) {
                existException = true
            } else {
                checkResult()
            }
        }
        lastData = data
    }

    override fun onDone() {
        checkResult()
    }

    /**
     * 计算一组数据的均值
     */
    private fun calAvg(list: List<DustSiteData>) {
        var total = .0
        var valid = true
        val count = list.size
        if (count == 0) return
        list.forEach {
            total += it.dustValue
            if (it.flag != DataStatus.N.value) {
                valid = false
            }
        }
        val avg = total / count
        avgListReverse.add(0, Pair(avg, valid))
    }

    /**
     * 计算数据组之间的均值差异是否连续超过限定比率
     */
    private fun checkSlideAvg(): Boolean {
        // 计算滑动均值最低要求个数
        val minSize = config.changeTrendTimes + config.changeTrendInterval
        if (avgListReverse.size < minSize) {
            return false
        } else {
            // 滑动均值满足数量时，计算均值之间是否连续超过限定比率
            val rateList = mutableListOf<Pair<Double, Boolean>>()
            for (i in avgListReverse.indices) {
                if (i >= config.changeTrendTimes) break
                val r = calAvgChangeRate(avgListReverse[i], avgListReverse[i + config.changeTrendInterval])
                rateList.add(r)
            }
            for (y in rateList) {
                if (!y.second || y.first < config.changeTrendRate) {
                    return false
                }
            }
            return true
        }
    }

    /**
     * 计算滑动均值变化率
     */
    private fun calAvgChangeRate(a1: Pair<Double, Boolean>, a2: Pair<Double, Boolean>): Pair<Double, Boolean> {
        val valid = a1.second && a2.second
        return if (a2.first == .0) {
            Pair(1.0, valid)
        } else {
            Pair(abs(a1.first - a2.first) / a2.first, valid)
        }
    }

    /**
     * 当前数据未出现异常时，或数据循环结束时，判断后续步骤
     */
    private fun checkResult() {
        if (existException) {
            resultList.add(newResult(startData!!, lastData))
            existException = false
        }
        // 判断并更新起始点位置
        val len = config.changeTrendGroup - 1 + config.changeTrendTimes + config.changeTrendInterval
        if ((eIndex - sIndex + 1) > len) {
            sIndex = eIndex + 1 - len
            startData = historyDataList[sIndex]
        }
    }
}