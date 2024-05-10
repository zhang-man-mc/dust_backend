package com.flightfeather.monitor.scheduledtasks.dust

import com.flightfeather.monitor.domain.ds1.repository.RequestTaskRep
import com.flightfeather.monitor.scheduledtasks.BaseTimingTask
import java.time.LocalDateTime

abstract class BaseDustTimingTask(private val requestTaskRep: RequestTaskRep) : BaseTimingTask() {

    // 任务是否延迟执行
    protected var taskDelay = false

    // 未使用到
    override val period: Long = 15L

    override fun execute(localtime: LocalDateTime) {
        doTask(localtime)
    }

    /**
     * 当任务开始执行时，判断任务状态，决定是否延迟执行
     */
    open fun isTaskDelay(localtime: LocalDateTime): Boolean {
        val task = requestTaskRep.findLatestTask(localtime)
        // 任务正在执行，跳过此次分析，在下一周期继续判断，等待任务完成后进行分析
        return if (task == null || task.runningStatus) {
            true
        } else !task.success
    }
}