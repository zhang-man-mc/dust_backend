package com.flightfeather.monitor.domain.ds1.repository

import com.flightfeather.monitor.domain.ds1.entity.RiskValue
import com.flightfeather.monitor.domain.ds1.mapper.RiskValueMapper
import com.github.pagehelper.PageHelper
import org.springframework.stereotype.Repository
import tk.mybatis.mapper.entity.Example
import java.time.LocalDate

@Repository
class RiskValueRep(private val riskValueMapper: RiskValueMapper) {

    /**
     * 获取最新一条记录
     */
    fun findLatestData(type: String): RiskValue? {
        val p = PageHelper.startPage<RiskValue>(1, 1)
        riskValueMapper.selectByExample(Example(RiskValue::class.java).apply {
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
     * 插入列表
     * @param list
     */
    fun insert(list: List<RiskValue>): Int {
        return riskValueMapper.insertList(list)
    }

    /**
     * 批量插入或更新,仅限同一日的或同一月的批量数据
     * @param list
     */
    fun insertOrUpdate(list: List<RiskValue>): Int {
        if (list.isEmpty()) return 0
        val newDataList = mutableListOf<RiskValue>()
        val oldDataList = mutableListOf<RiskValue>()
        val dataList = riskValueMapper.selectByExample(Example(RiskValue::class.java).apply {
            createCriteria().andEqualTo("lst", list[0].lst)
                .andEqualTo("type", list[0].type)
        })
        list.forEach { l ->
            val r = dataList.find { d ->
                d?.mnCode == l.mnCode
            }
            if (r != null) {
                l.id = r.id
                oldDataList.add(l)
            } else {
                newDataList.add(l)
            }
        }
        val r1 = riskValueMapper.insertList(newDataList)
        var r2 = 0
        oldDataList.forEach {
            r2 += riskValueMapper.updateByPrimaryKey(it)
        }
        return r1 + r2
    }

    /**
     * 查询
     * @param mnCode
     * @param date
     * @param type
     */
    fun select(mnCode: String, date: LocalDate, type: String): List<RiskValue?> {
        val s = date.withDayOfMonth(1).atStartOfDay()
        val e = s.plusMonths(1).minusSeconds(1)
        return riskValueMapper.selectByExample(Example(RiskValue::class.java).apply {
            createCriteria().andEqualTo("mnCode", mnCode)
                .andBetween("lst", s, e)
                .andEqualTo("type", type)
        })
    }
}