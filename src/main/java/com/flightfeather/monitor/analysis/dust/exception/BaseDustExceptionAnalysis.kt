package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.analysis.BaseDataAnalysis
import com.flightfeather.monitor.domain.ds1.entity.DustExceptionData
import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.enumration.dust.ExceptionType
import java.time.Duration

/**
 * 扬尘监测数据异常分析基类
 */
abstract class BaseDustExceptionAnalysis(config: DustExceptionSetting) :
    BaseDataAnalysis<DustSiteData, DustExceptionSetting, DustExceptionData>(config) {

    /**
     * 确定异常类型
     */
    abstract fun getExceptionType(): ExceptionType

    /**
     * 判断相邻数据是否连续
     */
    open fun isContinuous(d1: DustSiteData?, d2: DustSiteData): Boolean {
        if (d1 == null) return true

        val t1 = d1.lst
        val t2 = d2.lst
        return Duration.between(t1?.toInstant(), t2.toInstant()).toMinutes() <= 30
    }

    /**
     * 生成一条异常分析结果
     */
    open fun newResult(p: DustSiteData, n: DustSiteData?): DustExceptionData {
        val eType = getExceptionType()
        return DustExceptionData().apply {
            mnCode = p.mnCode
            exception = eType.des
            exceptionType = eType.value
            region = config.region
            beginTime = p.lst
            endTime = if (n == null) p.lst else n.lst
        }
    }
}