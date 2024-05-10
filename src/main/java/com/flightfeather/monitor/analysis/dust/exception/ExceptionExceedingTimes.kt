package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionData
import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.enumration.dust.DataStatus
import com.flightfeather.monitor.enumration.dust.ExceptionType
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

/**
 * 单日超标次数临近处罚标准异常分析
 */
class ExceptionExceedingTimes(config: DustExceptionSetting) : BaseDustExceptionAnalysis(config) {

    private var exceedingCount = 0
    private var startData: DustSiteData? = null

    override fun init() {
        super.init()
        exceedingCount = 0
        startData = null
    }

    override fun getExceptionType(): ExceptionType = ExceptionType.TYPE6

    override fun onNextData(data: DustSiteData) {
        if (startData == null) startData = data

        if (data.dustValue >= config.exceedingStandard && data.flag == DataStatus.N.value) {
            exceedingCount++
        }
    }

    override fun onDone() {
        if (exceedingCount >= config.dayExceedBorderlineLowNum && exceedingCount < config.dayExceedBorderlineHighNum) {
            startData?.let {
                val eType = getExceptionType()
                val t = LocalDateTime.ofInstant(it.lst.toInstant(), ZoneId.systemDefault()).withHour(0).withMinute(0).withSecond(0)
                val sT = Date.from(t.atZone(ZoneId.systemDefault()).toInstant())
                val n = t.plusDays(1).minusSeconds(1)
                val eT = Date.from(n.atZone(ZoneId.systemDefault()).toInstant())

                resultList.add(DustExceptionData().apply {
                    mnCode = it.mnCode
                    exception = eType.des
                    exceptionType = eType.value
                    region = config.region
                    beginTime = sT
                    endTime = eT
                })
            }
        }
    }
}