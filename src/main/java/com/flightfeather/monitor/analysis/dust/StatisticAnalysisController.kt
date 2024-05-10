package com.flightfeather.monitor.analysis.dust

import com.flightfeather.monitor.domain.ds1.repository.DustStatisticsValueRep
import com.flightfeather.monitor.utils.DateUtil
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

/**
 * 数据统计分析控制器
 */
@Component
class StatisticAnalysisController(private val dustStatisticsValueRep: DustStatisticsValueRep) {

    var running1 = false
    var running2 = false

    /**
     *
     */
    fun autoRunDailyStatics() {
        val data = dustStatisticsValueRep.findLatestData("day")
        val yesterday = LocalDate.now().minusDays(1)
        if (data == null) {
            // FIXME: 2023/10/23 应该是将所有数据进行统计
            dailyStatics(yesterday)
        } else {
            val date = LocalDateTime.ofInstant(data.lst.toInstant(), ZoneId.systemDefault())
            val sT = date.plusDays(1).toLocalDate()
            val du = DateUtil.findDurationDate(sT, yesterday)
            du.forEach {
                dailyStatics(it)
            }
        }
    }

    /**
     *
     */
    fun autoRunMonthlyStatics() {
        val data = dustStatisticsValueRep.findLatestData("month")
        val lastMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1)
        if (data == null) {
            // FIXME: 2023/10/23 应该是将所有数据进行统计
            monthlyStatics(lastMonth)
        } else {
            val date = LocalDateTime.ofInstant(data.lst.toInstant(), ZoneId.systemDefault())
            val sT = date.plusMonths(1).toLocalDate()
            val du = DateUtil.findDurationMonth(sT, lastMonth)
            du.forEach {
                monthlyStatics(it)
            }
        }
    }

    fun dailyStatics(date: LocalDate) {
        running1 = true
//        if (dustStatisticsValueRep.findDataExist(date, "day")) return
        dustStatisticsValueRep.dailyStatics(date)
        running1 = false
    }

    fun monthlyStatics(date: LocalDate) {
        running2 = true
//        if (dustStatisticsValueRep.findDataExist(date, "month")) return
        dustStatisticsValueRep.monthlyStatics(date)
        running2 = false
    }
}