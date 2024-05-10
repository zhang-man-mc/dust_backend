package com.flightfeather.monitor.scheduledtasks.dust

import com.flightfeather.monitor.analysis.dust.StatisticAnalysisController
import com.flightfeather.monitor.domain.ds1.repository.RequestTaskRep
import com.flightfeather.monitor.scheduledtasks.BaseTimingTask
import org.springframework.stereotype.Component
import java.time.LocalDateTime

/**
 * 扬尘月统计分析任务
 */
@Component
class DustMonthlyAnalysisTask(
    private val statisticAnalysisController: StatisticAnalysisController,
    requestTaskRep: RequestTaskRep,
) : BaseDustTimingTask(requestTaskRep) {

    override fun doTask(localtime: LocalDateTime) {
        if (taskDelay || (localtime.dayOfMonth == 1 && localtime.hour == 9 && localtime.minute == 0)) {
            taskDelay = isTaskDelay(localtime)
            if (!taskDelay) {
                log.info("月分析执行")
                statisticAnalysisController.autoRunMonthlyStatics()
            }
        }
    }
}