package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.enumration.dust.ExceptionType

/**
 * 数据临近超标异常分析
 */
class ExceptionApproachExceeding(config: DustExceptionSetting) : BaseExceptionContinuous(config) {

    override fun getExceptionType(): ExceptionType = ExceptionType.TYPE5

    override fun judgeException(p: DustSiteData?, n: DustSiteData): Boolean {
        // 判断数据是否在设定的临近超标范围内
        return n.dustValue >= config.nearExceedLowValue && n.dustValue <= config.nearExceedHighValue
    }

    override fun judgeDuration(sIndex: Int, eIndex: Int): Boolean {
        // 判断数据临近超标数量是否连续超过限定个数
        return (eIndex - 1 - sIndex) >= config.nearExceedNum
    }
}