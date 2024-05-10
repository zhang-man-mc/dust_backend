package com.flightfeather.monitor.scheduledtasks.dust

import com.flightfeather.monitor.analysis.dust.ExceptionAnalysisController
import com.flightfeather.monitor.domain.ds1.repository.RequestTaskRep
import com.flightfeather.monitor.scheduledtasks.BaseTimingTask
import org.springframework.stereotype.Component
import java.time.LocalDateTime

/**
 * 扬尘数据异常统计分析任务
 */
@Component
class DustExceptionAnalysisTask(
    private val exceptionAnalysisController: ExceptionAnalysisController,
    requestTaskRep: RequestTaskRep,
) : BaseDustTimingTask(requestTaskRep) {

    override fun doTask(localtime: LocalDateTime) {
        if (taskDelay || (localtime.hour == 8 && localtime.minute == 0)) {
            // 判断今日爬取任务是否完成
            taskDelay = isTaskDelay(localtime)
            if (!taskDelay) {
                log.info("异常分析执行")
                exceptionAnalysisController.init()
                exceptionAnalysisController.autoRun()
            }
        }
    }
}