package com.flightfeather.monitor.analysis.dust.exception

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.entity.DustSiteData

/**
 * 连续类型的异常分析基类,区别于父类的地方在于此种异常只和单个数据本身有关,于相邻数据无关
 */
abstract class BaseExceptionContinuousSingle(config: DustExceptionSetting) : BaseExceptionContinuous(config) {

    override fun onNextData(data: DustSiteData) {
        eIndex++
        if (lastData == null) {
            startData = data
        }
        // 判断相邻数据是否连续并且是否满足异常判断
        if (!isContinuous(lastData, data)) {
            checkResult()
            sIndex = eIndex
            startData = data
        } else {
            if (judgeException(lastData, data)) {
                // 修改了起始数据的位置,变更为出现异常的该值,而不是原来的出现异常的数据的前一个值
                if (!existException) {
                    sIndex = eIndex
                    startData = data
                }
                existException = true
            } else {
                checkResult()
            }
        }
        lastData = data
    }
}