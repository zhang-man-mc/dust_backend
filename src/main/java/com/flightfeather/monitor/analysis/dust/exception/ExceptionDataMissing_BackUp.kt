package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.enumration.dust.ExceptionType
import java.time.Duration

/**
 * 数据缺失异常分析
 */
class ExceptionDataMissing_BackUp(config: DustExceptionSetting) : BaseDustExceptionAnalysis(config) {

    private var lastData: DustSiteData? = null

    override fun init() {
        super.init()
        lastData = null
    }

    override fun getExceptionType(): ExceptionType = ExceptionType.TYPE0

    override fun onNextData(data: DustSiteData) {
        lastData?.let {
            val t1 = it.lst
            val t2 = data.lst
            val b1 = Duration.between(t1?.toInstant(), t2.toInstant()).toMinutes() >= config.missDataMinutes
            if (b1) {
                resultList.add(newResult(it, data))
            }
        }
        lastData = data
    }

    override fun onDone() {
        //do noting
    }
}