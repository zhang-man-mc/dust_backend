package com.flightfeather.monitor.analysis.dust

import com.flightfeather.monitor.analysis.dust.risk.*
import com.flightfeather.monitor.domain.ds1.repository.*
import com.flightfeather.monitor.enumration.dust.DeviceStatus
import com.flightfeather.monitor.utils.DateUtil
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

/**
 * 数据风险分析控制器
 */
@Component
class RiskAnalysisController(
    private val dustExceptionSettingRep: DustExceptionSettingRep,
    private val riskValueRep: RiskValueRep,
    private val dustSiteStatusRep: DustSiteStatusRep,
    private val dustSiteDataRep: DustSiteDataRep,
    private val dustExceptionDataRep: DustExceptionDataRep,
    private val dustStatisticValueRep: DustStatisticsValueRep,
) {

    var running1 = false
    var running2 = false

    private var taskDaily: DustRiskAnalysis? = null
    private var taskMonthly: DustRiskMonthAnalysis? = null

    fun init() {
        dustExceptionSettingRep.findLatestSetting("金山区")?.let {
            taskDaily = DustRiskAnalysis(it)
            taskMonthly = DustRiskMonthAnalysis(it)
        }
    }

    /**
     * 日风险统计,默认统计昨天的风险值
     */
    fun autoRunDaily() {
        val data = riskValueRep.findLatestData("day")
        val yesterday = LocalDate.now().minusDays(1)
        if (data == null) {
            runDaily(yesterday)
        } else {
            val date = LocalDateTime.ofInstant(data.lst.toInstant(), ZoneId.systemDefault())
            val sT = if (date.hour == 0 && date.minute == 0 && date.second == 0) {
                date.toLocalDate()
            } else {
                date.plusDays(1).toLocalDate()
            }
            val du = DateUtil.findDurationDate(sT, yesterday)
            du.forEach {
                runDaily(it)
            }
        }
    }

    /**
     * 月风险统计,根据昨日最新数据所在月份,统计该月的综合风险,截至昨天
     */
    fun autoRunMonthly() {
        val data = riskValueRep.findLatestData("month")
        val lastMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1)
        if (data == null) {
            runMonthly(lastMonth)
        } else {
            // 获取需要统计的最新月份,是昨天所在的月份(因为监测数据是今天获取昨天一整天的数据)
            val thisMonth = LocalDate.now().minusDays(1)
            // 最新月统计记录的时间
            val date = LocalDateTime.ofInstant(data.lst.toInstant(), ZoneId.systemDefault())
            val sT = date.toLocalDate()
            val du = DateUtil.findDurationMonth(sT, thisMonth)
            du.forEach {
                runMonthly(it)
            }
        }
    }

    fun runDaily(date: LocalDate) {
        running1 = true
        taskDaily?.init()
        // 获取所有当前上线和停运的设备
        dustSiteStatusRep.select(listOf(DeviceStatus.ONLINE, DeviceStatus.STOP)).forEach { s ->
            s?.let {
                taskDaily?.roundInit(s.mnCode, date)
                val dustSiteDataList = dustSiteDataRep.select(s.mnCode, date)
                val dustExceptionDataList = dustExceptionDataRep.select(s.mnCode, date)
                val dustStatisticValueList = dustStatisticValueRep.select(s.mnCode, date)
                if (dustStatisticValueList.isEmpty()) return@forEach
                taskDaily?.roundCal(dustStatisticValueList[0]!!, dustSiteDataList, dustExceptionDataList)
            }
        }
        // 所有分析结果入库
        if (taskDaily?.resultList?.isNotEmpty() == true) {
            riskValueRep.insert(taskDaily?.resultList!!)
        }
        running1 = false
    }

    fun runMonthly(date: LocalDate) {
        running2 = true
        taskMonthly?.init()
        dustSiteStatusRep.select(listOf(DeviceStatus.ONLINE, DeviceStatus.STOP)).forEach { s ->
            s?.let {
                taskMonthly?.roundInit(s.mnCode, date)
                val riskValueList = riskValueRep.select(s.mnCode, date, "day")
                taskMonthly?.roundCal(riskValueList)
            }
        }
        // 所有分析结果入库
        if (taskMonthly?.resultList?.isNotEmpty() == true) {
            riskValueRep.insertOrUpdate(taskMonthly?.resultList!!)
        }
        running2 = false
    }
}