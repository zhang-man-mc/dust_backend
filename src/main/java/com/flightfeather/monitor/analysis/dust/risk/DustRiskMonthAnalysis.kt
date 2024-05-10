package com.flightfeather.monitor.analysis.dust.risk

import com.flightfeather.monitor.domain.ds1.entity.*
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DustRiskMonthAnalysis(val config: DustExceptionSetting) {

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
            lst = Date.from(date.withDayOfMonth(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
            type = "month"
        })
    }

    /**
     * 每轮次的风险值计算
     */
    fun roundCal(list: List<RiskValue?>) {
        if (resultList.isEmpty()) throw IllegalStateException("结果集resultList不能为空！")

        val res = resultList.last()

        riskOnlineRate(res, list)
        riskValidRate(res, list)
        riskExceedRate(res, list)
        riskExceptionRepetitionRate(res, list)
        riskExceptionType(res, list)
    }

    fun riskOnlineRate(riskValue: RiskValue, list: List<RiskValue?>) {
        riskValue.onlineRisk = avg(list) { it.onlineRisk }
    }

    fun riskValidRate(riskValue: RiskValue, list: List<RiskValue?>) {
        riskValue.validRisk = avg(list) { it.validRisk }
    }

    fun riskExceedRate(riskValue: RiskValue, list: List<RiskValue?>) {
        riskValue.exceedRisk = avg(list) { it.exceedRisk }
    }

    fun riskExceptionRepetitionRate(riskValue: RiskValue, list: List<RiskValue?>) {
        riskValue.typicalExceptionRepetitionRate = avg(list) { it.typicalExceptionRepetitionRate }
    }

    fun riskExceptionType(riskValue: RiskValue, list: List<RiskValue?>) {
        riskValue.exceptionTypeAggregation = avg(list) { it.exceptionTypeAggregation }
    }


    private fun avg(list: List<RiskValue?>, onNext: (value: RiskValue) -> Double?): Double {
        var total = .0
        var count = 0
        list.forEach {
            if (it == null) return@forEach
            val a = onNext(it) ?: return@forEach
            total += a
            count++
        }
        return if (count == 0) .0 else total / count
    }
}