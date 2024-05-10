package com.flightfeather.monitor.scheduledtasks.dust

import com.flightfeather.monitor.analysis.dust.ExceptionAnalysisController
import com.flightfeather.monitor.analysis.dust.RiskAnalysisController
import com.flightfeather.monitor.analysis.dust.StatisticAnalysisController
import com.flightfeather.monitor.domain.ds1.repository.DustExceptionDataRep
import com.flightfeather.monitor.domain.ds1.repository.DustStatisticsValueRep
import com.flightfeather.monitor.domain.ds1.repository.RequestTaskRep
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

/**
 * 扬尘日风险分析任务
 */
@Component
class RiskDailyAnalysisTask(
    private val riskAnalysisController: RiskAnalysisController,
    private val exceptionAnalysisController: ExceptionAnalysisController,
    private val statisticAnalysisController: StatisticAnalysisController,
    private val dustExceptionDataRep: DustExceptionDataRep,
    private val dustStatisticsValueRep: DustStatisticsValueRep,
    requestTaskRep: RequestTaskRep,
) : BaseDustTimingTask(requestTaskRep) {

    override fun doTask(localtime: LocalDateTime) {
        if (taskDelay || (localtime.hour == 10 && localtime.minute == 0)) {
            taskDelay = isTaskDelay(localtime)
            if (!taskDelay) {
                log.info("日风险分析执行")
                riskAnalysisController.init()
                riskAnalysisController.autoRunDaily()
            }
        }
    }

    /**
     * 当昨日的异常分析和日统计任务都完成后，才执行日风险分析任务，否则延迟执行
     * @param localtime 当前时间
     * @return 是否延迟执行
     */
    override fun isTaskDelay(localtime: LocalDateTime): Boolean {
        val yesterday = LocalDate.now().minusDays(1)
        // 检查异常分析记录的最新时间和异常分析任务的运行状态
        val eData = dustExceptionDataRep.findLatestData() ?: return true
        val eDataTime = LocalDateTime.ofInstant(eData.endTime.toInstant(), ZoneId.systemDefault()).toLocalDate()
        val b1 = yesterday.isEqual(eDataTime)
        val b2 = exceptionAnalysisController.running
        // 检查日统计分析记录的最新时间和日统计分析任务的运行状态
        val sData = dustStatisticsValueRep.findLatestData("day") ?: return true
        val sDataTime = LocalDateTime.ofInstant(sData.lst.toInstant(), ZoneId.systemDefault()).toLocalDate()
        val b3 = yesterday.isEqual(sDataTime)
        val b4 = statisticAnalysisController.running1

        return !(b1 && !b2 && b3 && !b4)

    }
}