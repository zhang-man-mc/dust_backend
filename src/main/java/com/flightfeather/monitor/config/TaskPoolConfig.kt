package com.flightfeather.monitor.config

import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.aop.interceptor.AsyncExecutionAspectSupport
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor
import java.util.concurrent.ThreadPoolExecutor

@EnableAsync
@Configuration
class TaskPoolConfig {
    @Bean(name = [AsyncExecutionAspectSupport.DEFAULT_TASK_EXECUTOR_BEAN_NAME])
    fun taskExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        //核心线程池大小
        executor.corePoolSize = 10
        //最大线程数
        executor.maxPoolSize = 20
        //队列容量
        executor.queueCapacity = 200
        //活跃时间
        executor.keepAliveSeconds = 60
        //线程名字前缀
        executor.setThreadNamePrefix("taskExecutor-")
        executor.setRejectedExecutionHandler(ThreadPoolExecutor.CallerRunsPolicy())
        return executor
    }
}