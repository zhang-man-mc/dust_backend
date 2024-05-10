package com.flightfeather.monitor.scheduledtasks

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

/**
 * 定时任务基类
 */
abstract class BaseTimingTask {

    companion object {
        val log: Logger = LoggerFactory.getLogger(BaseTimingTask::class.java)
    }

    // 记录上次任务执行的时间点，单位：毫秒
    private var lastTime: LocalDateTime = LocalDateTime.MIN

    // 任务执行周期，单位：分钟
    abstract val period: Long

    open fun execute(localtime:LocalDateTime) {
        val now = LocalDateTime.now()
        if (now.minusSeconds(period * 60 - 5) >= lastTime) {
            lastTime = now
            doTask(localtime)
        }
    }

    abstract fun doTask(localtime:LocalDateTime)
}