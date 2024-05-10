package com.flightfeather.monitor.domain.ds1.repository

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionData
import com.flightfeather.monitor.domain.ds1.mapper.DustExceptionDataMapper
import com.github.pagehelper.PageHelper
import org.springframework.stereotype.Repository
import tk.mybatis.mapper.entity.Example
import java.time.LocalDate

@Repository
class DustExceptionDataRep(private val dustExceptionDataMapper: DustExceptionDataMapper) {

    /**
     * 获取最新一条记录
     */
    fun findLatestData(): DustExceptionData? {
        val p = PageHelper.startPage<DustExceptionData>(1, 1)
        dustExceptionDataMapper.selectByExample(Example(DustExceptionData::class.java).apply {
            orderBy("endTime").desc()
        })
        return if (p.isNotEmpty()) {
            p[0]
        } else {
            null
        }
    }

    /**
     * 判断某天的异常分析数据是否存在
     */
    fun findDataExist(date: LocalDate): Boolean {
        val s = date.atStartOfDay()
        val e = s.plusDays(1).minusSeconds(1)
        val res = dustExceptionDataMapper.selectOneByExample(Example(DustExceptionData::class.java).apply {
            createCriteria().andBetween("endTime", s, e)
        })
        return res != null
    }

    /**
     * 存储异常分析结果
     */
    fun insert(list: List<DustExceptionData>): Int {
        return dustExceptionDataMapper.insertList(list)
    }

    fun select(mnCode: String, date: LocalDate): List<DustExceptionData?> {
        val s = date.atStartOfDay()
        val e = s.plusDays(1).minusSeconds(1)
        return dustExceptionDataMapper.selectByExample(Example(DustExceptionData::class.java).apply {
            createCriteria().andBetween("beginTime", s, e)
                .andEqualTo("mnCode", mnCode)
            orderBy("beginTime")
        })
    }
}