package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionData
import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.enumration.dust.DataStatus
import com.flightfeather.monitor.enumration.dust.ExceptionType

/**
 * 数据超低异常分析
 */
class ExceptionDataLowValue(config: DustExceptionSetting) : BaseExceptionContinuousSingle(config) {

    override fun getExceptionType(): ExceptionType = ExceptionType.TYPE1

    override fun judgeException(p: DustSiteData?, n: DustSiteData): Boolean {
        val b1 = n.flag == DataStatus.OUT_MIN.value
        val b2 = n.dustValue <= config.dataLow && n.flag == DataStatus.N.value
        val b3 = n.flag == DataStatus.Q.value
        return b1 || b2 || b3
    }

    override fun judgeDuration(sIndex: Int, eIndex: Int): Boolean {
        return true
    }
}