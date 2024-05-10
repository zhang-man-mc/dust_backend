package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData
import com.flightfeather.monitor.enumration.dust.DataStatus
import com.flightfeather.monitor.enumration.dust.ExceptionType
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

/**
 * 数据缺失异常分析
 */
class ExceptionDataMissing(config: DustExceptionSetting) : BaseExceptionContinuous(config) {

    override fun getExceptionType(): ExceptionType = ExceptionType.TYPE0

//    override fun onNextData(data: DustSiteData) {
//        lastData?.let {
//            val t1 = it.lst
//            val t2 = data.lst
//            val b1 = Duration.between(t1?.toInstant(), t2.toInstant()).toMinutes() >= config.missDataMinutes
//            if (b1) {
//                resultList.add(newResult(it, data))
//            }
//        }
//        lastData = data
//    }

    override fun judgeException(p: DustSiteData?, n: DustSiteData): Boolean {
        // 数据缺失异常不同于其他异常的点在于当日首个数据如果不存在，需要做一次判断
        var pData: DustSiteData? = null
        if (p == null) {
            //当首个数据进入时，需要判断是否为当日的第一个数据
            val time = LocalDateTime.ofInstant(n.lst.toInstant(), ZoneId.systemDefault())
            if (time.hour == 0 && time.minute == 0) {
                return false
            }
            // 如果缺失当日首个数据，则需要将当前数据n和当日0点进行比较，记录数据缺失异常
            else {
                startData = DustSiteData().apply {
                    mnCode = n.mnCode
                    lst = Date.from(time.withHour(0).withMinute(0).withSecond(0).atZone(ZoneId.systemDefault())
                        .toInstant())
                    flag = DataStatus.A.value
                }
                pData = startData
            }
        }
        if (pData == null) return false
        val t1 = pData.lst
        val t2 = n.lst
        val b1 = Duration.between(t1?.toInstant(), t2.toInstant()).toMinutes() >= config.missDataMinutes
        val b2 = n.flag == DataStatus.A.value || n.flag == DataStatus.D.value
        return b1 || b2
    }

    override fun judgeDuration(sIndex: Int, eIndex: Int): Boolean {
        return true
    }

    /**
     * 针对数据缺失异常, 对数据的连续性不做判断
     */
    override fun isContinuous(d1: DustSiteData?, d2: DustSiteData): Boolean {
        return true
    }
}