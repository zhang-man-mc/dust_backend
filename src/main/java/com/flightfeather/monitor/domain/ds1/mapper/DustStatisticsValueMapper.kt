package com.flightfeather.monitor.domain.ds1.mapper

import com.flightfeather.monitor.domain.ds1.entity.DustStatisticsValue
import com.flightfeather.monitor.domain.util.MyMapper
import com.flightfeather.monitor.pojo.AnalysisDustData
import org.apache.ibatis.annotations.Mapper
import java.time.LocalDateTime

@Mapper
interface DustStatisticsValueMapper : MyMapper<DustStatisticsValue?> {

    fun dailyStatics(beginTime: LocalDateTime, endTime: LocalDateTime)

    fun monthlyStatics(beginTime: LocalDateTime, endTime: LocalDateTime, count: Int)

    /**
     * 根据条件排序查询
     */
    fun selectByOrder(siteName: String, beginTime: String, endTime: String, orderProp: String?, asc: Boolean):
            List<AnalysisDustData?>
}