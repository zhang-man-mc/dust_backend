package com.flightfeather.monitor.scheduledtasks

import com.flightfeather.monitor.scheduledtasks.dust.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

/**
 * 数据获取控制器
 */
@Component
class TaskController(
    dustExceptionAnalysisTask: DustExceptionAnalysisTask,
    dustDailyAnalysisTask: DustDailyAnalysisTask,
    dustMonthlyAnalysisTask: DustMonthlyAnalysisTask,
    riskDailyAnalysisTask: RiskDailyAnalysisTask,
    riskMonthlyAnalysisTask: RiskMonthlyAnalysisTask,
) {

    companion object {
        private const val FETCH_PERIOD_MIN = 15L
        private const val MAINTAIN_PERIOD_MIN = 15L
        val log: Logger = LoggerFactory.getLogger(TaskController::class.java)
    }

    private val timeTask = mutableListOf<BaseTimingTask>()
    private var schedule = Executors.newScheduledThreadPool(1)
    private var maintainSchedule = Executors.newScheduledThreadPool(1)
    private var taskTime: Date = Date()
    private var maintainTime: Date = Date()

    init {
        log.info("添加定时任务")
        timeTask.clear()
        timeTask.add(dustExceptionAnalysisTask)
        timeTask.add(dustDailyAnalysisTask)
        timeTask.add(dustMonthlyAnalysisTask)
        timeTask.add(riskDailyAnalysisTask)
        timeTask.add(riskMonthlyAnalysisTask)
        log.info("添加定时任务完成，任务总计${timeTask.size}个")
    }

    fun run() {
        fetchTask(true)
        maintainTask(true)
    }

    private fun fetchTask(isFirst: Boolean = false) {
        val time = LocalTime.now()
        val min = time.minute
        val delay = FETCH_PERIOD_MIN - min % FETCH_PERIOD_MIN
//        var localtime = LocalDateTime.of(2021, 4, 16, 9, 0)
        if (!isFirst) {
            schedule = closeThread(schedule)
        }
        schedule.scheduleAtFixedRate({
            taskTime = Date()
            if (Date().time - maintainTime.time > (MAINTAIN_PERIOD_MIN + 1) * 60 * 1000) {
                maintainTask()
            }

            val localtime = LocalDateTime.now()
//            LOGGER.info("定时任务执行，定时任务数：${timeTask.size}")
            timeTask.forEach {
//                LOGGER.info("定时任务：${it.javaClass.name}")
                it.execute(localtime)
            }
//            localtime = localtime.plusMinutes(1)
        }, delay, FETCH_PERIOD_MIN, TimeUnit.MINUTES)
    }

    private fun maintainTask(isFirst: Boolean = false) {
        if (!isFirst) {
            maintainSchedule = closeThread(maintainSchedule)
        }
        maintainSchedule.scheduleAtFixedRate({
            maintainTime = Date()
            if (Date().time - taskTime.time > (FETCH_PERIOD_MIN + 1) * 60 * 1000) {
                fetchTask()
            }
        }, 0, MAINTAIN_PERIOD_MIN, TimeUnit.MINUTES)
    }

    private fun closeThread(s: ScheduledExecutorService): ScheduledExecutorService {
        try {
            s.shutdown()
            if (s.awaitTermination(10, TimeUnit.SECONDS)) {
                s.shutdownNow()
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
            s.shutdownNow()
        }
        return Executors.newScheduledThreadPool(1)
    }
}