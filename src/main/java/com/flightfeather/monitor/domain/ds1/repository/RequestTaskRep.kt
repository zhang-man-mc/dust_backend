package com.flightfeather.monitor.domain.ds1.repository

import com.flightfeather.monitor.domain.ds1.entity.RequestTask
import com.flightfeather.monitor.domain.ds1.mapper.RequestTaskMapper
import com.github.pagehelper.PageHelper
import org.springframework.stereotype.Repository
import tk.mybatis.mapper.entity.Example
import java.time.LocalDateTime

@Repository
class RequestTaskRep(private val requestTaskMapper: RequestTaskMapper) {

    /**
     * 查询最近的一个任务
     */
    fun findLatestTask(localDateTime: LocalDateTime): RequestTask? {
        val p = PageHelper.startPage<RequestTask>(1, 1)
        val s = localDateTime.withHour(0).withMinute(0).withSecond(0)
        val e = localDateTime.withHour(23).withMinute(59).withSecond(59)
        requestTaskMapper.selectByExample(Example(RequestTask::class.java).apply {
            createCriteria().andBetween("startTime", s, e)
            orderBy("startTime").desc()
        })
        return if (p.isNotEmpty()) {
            p[0]
        } else {
            null
        }
    }
}