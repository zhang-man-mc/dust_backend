package com.flightfeather.monitor.domain.ds1.repository

import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.domain.ds1.mapper.DustSiteDataMapper
import org.springframework.stereotype.Repository
import tk.mybatis.mapper.entity.Example
import java.time.LocalDate

@Repository
class DustSiteDataRep(private val dustSiteDataMapper: DustSiteDataMapper) {

    /**
     * 获取某个站点某一天的所有记录
     */
    fun select(mnCode: String, date: LocalDate): List<DustSiteData?> {
        val s = date.atStartOfDay()
        val e = s.plusDays(1).minusSeconds(1)
        return dustSiteDataMapper.selectByExample(Example(DustSiteData::class.java).apply {
            createCriteria().andBetween("lst", s, e)
                .andEqualTo("mnCode", mnCode)
            orderBy("lst")
        })
    }

    /**
     * 判断某天的监测数据是否存在
     */
    fun findDataExist(date: LocalDate): Boolean {
        val s = date.atStartOfDay()
        val e = s.plusDays(1).minusSeconds(1)
        val res = dustSiteDataMapper.selectOneByExample(Example(DustSiteData::class.java).apply {
            createCriteria().andBetween("lst", s, e)
        })
        return res != null
    }
}