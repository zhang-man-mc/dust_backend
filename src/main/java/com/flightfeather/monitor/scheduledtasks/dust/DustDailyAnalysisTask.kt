package com.flightfeather.monitor.scheduledtasks.dust

import com.flightfeather.monitor.analysis.dust.StatisticAnalysisController
import com.flightfeather.monitor.domain.ds1.repository.RequestTaskRep
import org.springframework.stereotype.Component
import java.time.LocalDateTime

/**
 * 扬尘日统计分析任务
 */
@Component
class DustDailyAnalysisTask(
    private val statisticAnalysisController: StatisticAnalysisController,
    requestTaskRep: RequestTaskRep,
) : BaseDustTimingTask(requestTaskRep) {

    override fun doTask(localtime: LocalDateTime) {
        if (taskDelay || (localtime.hour == 9 && localtime.minute == 0)) {
            taskDelay = isTaskDelay(localtime)
            if (!taskDelay) {
                log.info("日分析执行")
                statisticAnalysisController.autoRunDailyStatics()
            }
        }
    }
}