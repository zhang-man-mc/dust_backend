package com.flightfeather.monitor.analysis.dust.risk

import com.flightfeather.monitor.domain.ds1.entity.*
import com.flightfeather.monitor.enumration.dust.ExceptionType
import java.time.LocalDate
import java.time.ZoneId
import java.util.*
import kotlin.math.round

/**
 * 扬尘监测数据风险分析基类
 */
class DustRiskAnalysis(val config: DustExceptionSetting) {

    //分析结果
    val resultList = mutableListOf<RiskValue>()

    /**
     * 初始化
     */
    fun init() {
        resultList.clear()
    }

    /**
     * 每轮次的初始化
     */
    fun roundInit(mnCode: String, date: LocalDate) {
        resultList.add(RiskValue().apply {
            this.mnCode = mnCode
            lst = Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
            type = "day"
        })
    }

    /**
     * 每轮次的风险值计算
     */
    fun roundCal(data: DustStatisticsValue, list: List<DustSiteData?>, dList: List<DustExceptionData?>) {
        if (resultList.isEmpty()) throw IllegalStateException("结果集resultList不能为空！")

        val res = resultList.last()
        riskOnlineRate(res, data)
        riskValidRate(res, data)
        riskExceedRate(res, list)
        riskExceptionRepetitionRate(res, dList)
        riskExceptionType(res, dList)
    }

    /**
     * 在线率风险值
     */
    fun riskOnlineRate(riskValue: RiskValue, data: DustStatisticsValue) {
        val dayOnline = data.dayOnline
        riskValue.onlineRisk = round((1 - dayOnline) * 10000) / 10000
    }

    /**
     * 有效率风险值
     */
    fun riskValidRate(riskValue: RiskValue, data: DustStatisticsValue) {
        val dayValid = data.dayValid
        riskValue.validRisk = round((1 - dayValid) * 10000) / 10000
    }

    /**
     * 超标风险值
     */
    fun riskExceedRate(riskValue: RiskValue, list: List<DustSiteData?>) {
        // 日超标次数/7（大于1mg/m³，小于2mg/m³）
        var v1 = 0
        // 日超标次数/2（大于2mg/m³）
        var v2 = 0
        // 日临近超标次数/7
        var v3 = 0
        list.forEach { d ->
            if (d == null) return@forEach
            when {
                d.dustValue >= 2.0 -> v2++
                d.dustValue >= 1.0 && d.dustValue < 2.0 -> v1++
                d.dustValue >= config.nearExceedLowValue && d.dustValue < config.nearExceedHighValue -> v3++
            }
        }
        // 和的最大值为3最小值为0，上述之和除以3，结果最大值为1最小值为0，即为日超标风险值
        val r = (v1 + v2 + v3) / 3.0
        riskValue.exceedRisk = if (r > 1) 1.0 else r
    }

    /**
     * 典型异常复现率
     */
    fun riskExceptionRepetitionRate(riskValue: RiskValue, list: List<DustExceptionData?>) {
        //1、针对量级突变异常、临近超标异常、单日超标次数临界异常的指定时段（如24小时内）重复出现概率来综合判定典型异常复现率；
        //2、日量级突变异常复现率（E4）：（N4-1）/4， 最大为1，最小为0
        //3、日临近超标异常复现率（E5）：（N5-1）/3， 最大为1，最小为0
        //4、日超标次数临界异常复现率（E6）：（N6-1）/2， 最大为1，最小为0
        //5、日典型异常复现率: 取E4、E5、E6的和，最大为1，最小为0
        //6、月典型异常复现率：当月内各日典型异常复现率的和/当月天数，最大为1，最小为0
        var v1 = 0
        var v2 = 0
        var v3 = 0
        list.forEach { d ->
            if (d == null) return@forEach
            when (d.exceptionType) {
                ExceptionType.TYPE4.value -> v1++
                ExceptionType.TYPE5.value -> v2++
                ExceptionType.TYPE6.value -> v3++
            }
        }
        val e1 = settingRange((v1 - 1) / 4.0)
        val e2 = settingRange((v2 - 1) / 3.0)
        val e3 = settingRange((v3 - 1) / 2.0)
        riskValue.typicalExceptionRepetitionRate = settingRange(e1 + e2 + e3)
    }

    /**
     * 异常类型聚集率
     */
    fun riskExceptionType(riskValue: RiskValue, list: List<DustExceptionData?>) {
        // 日异常类型聚集率：当日出现的不同异常类型个数/6，最大为1，最小为0
        //2、月异常类型聚集率：当月内各日异常类型聚集率的和/当月天数，最大为1，最小为0
        // 其他时段以此类推，数据超低、长时间无波动等两类异常暂不纳入分析，若纳入分析则分母为8
        val exceptionTypes = mutableListOf<Int>()
        list.forEach { d ->
            if (d == null) return@forEach
            if (!exceptionTypes.contains(d.exceptionType)) {
                if (d.exceptionType != ExceptionType.TYPE1.value && d.exceptionType != ExceptionType.TYPE3.value) {
                    exceptionTypes.add(d.exceptionType)
                }
            }
        }
        riskValue.exceptionTypeAggregation = exceptionTypes.size / 6.0
    }

    private fun settingRange(d: Double): Double = if (d > 1) 1.0 else if (d < 0) .0 else d
}