package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.enumration.dust.DataStatus
import com.flightfeather.monitor.enumration.dust.ExceptionType

/**
 * 数据超标异常分析
 */
class ExceptionDataExceed(config: DustExceptionSetting) : BaseExceptionContinuousSingle(config) {

    override fun getExceptionType(): ExceptionType = ExceptionType.TYPE2

    override fun judgeException(p: DustSiteData?, n: DustSiteData): Boolean {
        return n.dustValue >= config.exceedingStandard && n.flag == DataStatus.N.value
    }

    override fun judgeDuration(sIndex: Int, eIndex: Int): Boolean {
        return true
    }
}