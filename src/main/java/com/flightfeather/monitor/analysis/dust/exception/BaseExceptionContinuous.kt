package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData

/**
 * 连续类型的异常分析基类,适用于当前数据与相邻数据之间有关联关系的情况
 */
abstract class BaseExceptionContinuous(config: DustExceptionSetting) : BaseDustExceptionAnalysis(config) {

    // 起始数据下标
    protected var sIndex = 0
    // 起始数据对象
    protected var startData: DustSiteData? = null
    // 末尾数据下标
    protected var eIndex = -1
    // 末尾数据对象
    protected var lastData: DustSiteData? = null
    // 起始数据与末尾数据间隔
    open var durationCount = 1
    protected var existException = false

    /**
     * 判断是否满足异常条件
     */
    abstract fun judgeException(p: DustSiteData?, n: DustSiteData): Boolean

    /**
     * 判断异常出现的连续时长是否满足条件
     */
    abstract fun judgeDuration(sIndex: Int, eIndex: Int): Boolean

    override fun init() {
        super.init()
        startData = null
        lastData = null
        sIndex = 0
        eIndex = -1
        existException = false
    }

    override fun onNextData(data: DustSiteData) {
        eIndex++
        if (lastData == null) {
            startData = data
        }
        // 判断相邻数据是否连续并且是否满足异常判断
        if (!isContinuous(lastData, data)) {
            checkResult()
            if (eIndex - sIndex >= durationCount) {
                sIndex = eIndex
                startData = data
            }
        } else {
            if (judgeException(lastData, data)) {
                existException = true
            } else {
                checkResult()
                if (eIndex - sIndex >= durationCount) {
                    sIndex = eIndex
                    startData = data
                }
            }
        }
//        if (!(isContinuous(lastData, data) && judgeException(lastData, data))) {
//
//        }
        lastData = data
    }

    override fun onDone() {
        checkResult()
    }

    /**
     * 检查连续异常结束时，是否符合异常存储条件
     */
    open fun checkResult() {
        if (existException && judgeDuration(sIndex, eIndex)) {
            startData?.let {
                resultList.add(newResult(it, lastData))
            }
            existException = false
        }
    }
}