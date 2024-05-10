package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.enumration.dust.DataStatus
import com.flightfeather.monitor.enumration.dust.ExceptionType

/**
 * 数据长时间无波动异常分析
 */
class ExceptionNoFluctuation(config: DustExceptionSetting) : BaseExceptionContinuous(config) {

    override fun getExceptionType(): ExceptionType = ExceptionType.TYPE3

    override fun judgeException(p: DustSiteData?, n: DustSiteData): Boolean {
        if (p == null) return false
        val b1 = p.dustValue == n.dustValue
        val b2 = p.flag != DataStatus.A.value && p.flag != DataStatus.D.value
        val b3 = n.flag != DataStatus.A.value && n.flag != DataStatus.D.value
        return b1 && b2 && b3
    }

    override fun judgeDuration(sIndex: Int, eIndex: Int): Boolean {
        return (eIndex - 1 - sIndex) >= config.longTimeNoChange
    }
}