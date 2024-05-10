package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.enumration.dust.DataStatus
import com.flightfeather.monitor.enumration.dust.ExceptionType
import kotlin.math.abs

/**
 * 量级突变异常分析
 */
class ExceptionValueMutation(config: DustExceptionSetting) : BaseExceptionContinuous(config) {

    /**
     * 本异常的连续发生次数会根据异常的程度变化
     * 当突变的量级超过设定值1倍是,连续发生次数要求减少1倍
     */
    private var special = false

    override fun getExceptionType(): ExceptionType = ExceptionType.TYPE4

    override fun judgeException(p: DustSiteData?, n: DustSiteData): Boolean {
        if (p == null) return false
        val r = abs((p.dustValue - n.dustValue) / p.dustValue)
        val b1 = r >= (2 * config.mutationRate) && n.flag == DataStatus.N.value
        val b2 = r >= config.mutationRate && n.flag == DataStatus.N.value
        val b3 = n.flag == DataStatus.OUT_MAX.value
        if (b1) special = true
        return b1 || b2 || b3
    }

    override fun judgeDuration(sIndex: Int, eIndex: Int): Boolean {
        val b1 = special && (eIndex - 1 - sIndex) >= (config.mutationNum / 2)
        val b2 = (eIndex - 1  - sIndex) >= config.mutationNum
        special = false
        return b1 || b2
    }
}