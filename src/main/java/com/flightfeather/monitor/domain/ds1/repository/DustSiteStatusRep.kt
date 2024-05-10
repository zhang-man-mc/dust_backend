package com.flightfeather.monitor.domain.ds1.repository

import com.flightfeather.monitor.domain.ds1.entity.DustSiteStatus
import com.flightfeather.monitor.domain.ds1.mapper.DustSiteStatusMapper
import com.flightfeather.monitor.enumration.dust.DeviceStatus
import org.springframework.stereotype.Repository
import tk.mybatis.mapper.entity.Example

@Repository
class DustSiteStatusRep(private val dustSiteStatusMapper: DustSiteStatusMapper) {

    /**
     * 获取站点状态
     * @param status 站点状态
     */
    fun select(status: List<DeviceStatus>): List<DustSiteStatus?> {
        return dustSiteStatusMapper.selectByExample(Example(DustSiteStatus::class.java).apply {
            createCriteria().apply {
                status.forEach {
                    orEqualTo("deviceStatus", it.value)
                }
            }
        })
    }
}