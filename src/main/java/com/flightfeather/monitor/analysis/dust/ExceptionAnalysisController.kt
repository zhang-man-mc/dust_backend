package com.flightfeather.monitor.analysis.dust

import com.flightfeather.monitor.analysis.dust.exception.*
import com.flightfeather.monitor.domain.ds1.entity.DustExceptionData
import com.flightfeather.monitor.domain.ds1.repository.DustExceptionDataRep
import com.flightfeather.monitor.domain.ds1.repository.DustExceptionSettingRep
import com.flightfeather.monitor.domain.ds1.repository.DustSiteDataRep
import com.flightfeather.monitor.domain.ds1.repository.DustSiteStatusRep
import com.flightfeather.monitor.enumration.dust.DeviceStatus
import com.flightfeather.monitor.utils.DateUtil
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

/**
 * 数据异常分析控制器
 */
@Component
class ExceptionAnalysisController(
    private val dustExceptionDataRep: DustExceptionDataRep,
    private val dustExceptionSettingRep: DustExceptionSettingRep,
    private val dustSiteDataRep: DustSiteDataRep,
    private val dustSiteStatusRep: DustSiteStatusRep,
) {

    var running = false

    private val taskList = mutableListOf<BaseDustExceptionAnalysis>()

    fun init() {
        dustExceptionSettingRep.findLatestSetting("金山区")?.let {
            taskList.clear()
            taskList.apply {
                add(ExceptionDataMissing(it))
                add(ExceptionNoFluctuation(it))
                add(ExceptionApproachExceeding(it))
                add(ExceptionExceedingTimes(it))
                add(ExceptionSlideAverage(it))
                add(ExceptionValueMutation(it))
                add(ExceptionDataLowValue(it))
                add(ExceptionDataExceed(it))
                add(ExceptionValidRate(it))
            }
        }
    }

    /**
     * 自动运行时的处理逻辑
     * 分析昨天的数据
     */
    fun autoRun() {
        val data = dustExceptionDataRep.findLatestData()
        val yesterday = LocalDate.now().minusDays(1)
        if (data == null) {
            // FIXME: 2023/10/23 应该是将所有数据进行统计
            run(yesterday)
        } else {
            val date = LocalDateTime.ofInstant(data.endTime.toInstant(), ZoneId.systemDefault())
            val sT = if (date.hour == 0 && date.minute == 0 && date.second == 0) {
                date.toLocalDate()
            } else {
                date.plusDays(1).toLocalDate()
            }
            val du = DateUtil.findDurationDate(sT, yesterday)
            du.forEach {
                run(it)
            }
        }
    }

    fun run(date: LocalDate) {
        running = true
        // 判断对应日期的异常分析是否存在
//        if (dustExceptionDataRep.findDataExist(date)) return
        // 获取所有当前上线的设备
        val result = mutableListOf<DustExceptionData>()
        dustSiteStatusRep.select(listOf(DeviceStatus.ONLINE, DeviceStatus.STOP)).forEach { s ->
            s?.let {
                taskList.forEach { it.init() }
                // 轮询数据，计算各个异常
                dustSiteDataRep.select(s.mnCode, date).takeIf { it.isNotEmpty() }?.forEach {d ->
                    d?.let { taskList.forEach { it.onNextData(d) } }
                }
                // 各个异常分析分别结束
                taskList.forEach { it.onDone() }
                // 存储分析结果
                taskList.forEach {
                    result.addAll(it.resultList)
                }
            }
        }
        // 所有分析结果入库
        if (result.isNotEmpty()) {
            dustExceptionDataRep.insert(result)
        }
        running = false
    }

    fun debugRun() {
        val result = mutableListOf<DustExceptionData>()
        val date = LocalDate.of(2023, 11, 22)
        taskList.forEach { it.init() }
        // 轮询数据，计算各个异常
        val list = dustSiteDataRep.select("SHKJ0JS0150917", date)
        list.takeIf { it.isNotEmpty() }?.forEach { d ->
            d?.let { taskList.forEach { it.onNextData(d) } }
        }
        // 各个异常分析分别结束
        taskList.forEach { it.onDone() }
        // 存储分析结果
        taskList.forEach { result.addAll(it.resultList) }
        println(result)
    }
}