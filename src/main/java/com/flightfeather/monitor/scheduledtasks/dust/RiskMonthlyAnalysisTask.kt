package com.flightfeather.monitor.scheduledtasks.dust

import com.flightfeather.monitor.analysis.dust.RiskAnalysisController
import com.flightfeather.monitor.domain.ds1.repository.RequestTaskRep
import com.flightfeather.monitor.domain.ds1.repository.RiskValueRep
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

/**
 * 扬尘月风险分析任务
 */
@Component
class RiskMonthlyAnalysisTask(
    private val riskAnalysisController: RiskAnalysisController,
    private val riskValueRep: RiskValueRep,
    requestTaskRep: RequestTaskRep,
) : BaseDustTimingTask(requestTaskRep) {

    override fun doTask(localtime: LocalDateTime) {
        if (taskDelay || (localtime.hour == 11 && localtime.minute == 0)) {
            taskDelay = isTaskDelay(localtime)
            if (!taskDelay) {
                log.info("月风险分析执行")
                riskAnalysisController.init()
                riskAnalysisController.autoRunMonthly()
            }
        }
    }

    /**
     * 当上月底的日风险分析完成后，才执行月风险分析任务，否则延迟执行
     * @param localtime 当前时间
     * @return 是否延迟执行
     */
    override fun isTaskDelay(localtime: LocalDateTime): Boolean {
        val lastMonth = LocalDate.now().withDayOfMonth(1).minusDays(1)
        val data = riskValueRep.findLatestData("day") ?: return true
        val dataTime = LocalDateTime.ofInstant(data.lst.toInstant(), ZoneId.systemDefault()).toLocalDate()
        val b1 = lastMonth.isEqual(dataTime)
        val b2 = riskAnalysisController.running1

        return !(b1 && !b2)

    }
}