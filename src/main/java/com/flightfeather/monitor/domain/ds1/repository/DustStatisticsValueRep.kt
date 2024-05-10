package com.flightfeather.monitor.domain.ds1.repository

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionData
import com.flightfeather.monitor.domain.ds1.entity.DustStatisticsValue
import com.flightfeather.monitor.domain.ds1.mapper.DustStatisticsValueMapper
import com.github.pagehelper.PageHelper
import org.springframework.stereotype.Repository
import tk.mybatis.mapper.entity.Example
import java.time.Duration
import java.time.LocalDate

@Repository
class DustStatisticsValueRep(private val dustStatisticsValueMapper: DustStatisticsValueMapper) {

    fun findLatestData(type: String): DustStatisticsValue? {
        val p = PageHelper.startPage<DustStatisticsValue>(1, 1)
        dustStatisticsValueMapper.selectByExample(Example(DustStatisticsValue::class.java).apply {
            createCriteria().andEqualTo("type", type)
            orderBy("lst").desc()
        })
        return if (p.isNotEmpty()) {
            p[0]
        } else {
            null
        }
    }


    /**
     * 判断某日的统计是否存在
     */
    fun findDataExist(date: LocalDate, type: String): Boolean {
        val s = date.atStartOfDay()
        val e = date.atStartOfDay().minusSeconds(1)
        val res = dustStatisticsValueMapper.selectOneByExample(Example(DustStatisticsValue::class.java).apply {
            createCriteria().andBetween("lst", s, e)
                .andEqualTo("type", type)
        })
        return res != null
    }

    fun dailyStatics(date: LocalDate) {
        val s = date.atStartOfDay()
        val e = s.plusDays(1).minusSeconds(1)
        dustStatisticsValueMapper.dailyStatics(s, e)
    }

    fun monthlyStatics(date: LocalDate) {
        val s = date.withDayOfMonth(1).atStartOfDay()
        val e = s.plusMonths(1).minusSeconds(1)
        val d = Duration.between(s, e).toDays() + 1
        val dataCount = d * 96
        dustStatisticsValueMapper.monthlyStatics(s, e, dataCount.toInt())
    }

    fun select(mnCode: String, date: LocalDate): List<DustStatisticsValue?> {
        return dustStatisticsValueMapper.selectByExample(Example(DustStatisticsValue::class.java).apply {
            createCriteria().andEqualTo("lst", date)
                .andEqualTo("mnCode", mnCode)
        })
    }
}