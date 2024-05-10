package com.flightfeather.monitor.domain.ds1.mapper

import com.flightfeather.monitor.domain.ds1.entity.RiskValue
import com.flightfeather.monitor.domain.util.MyMapper
import com.flightfeather.monitor.pojo.RiskValuePojo
import org.apache.ibatis.annotations.Mapper
import sun.util.resources.LocaleData
import java.time.LocalDate
import java.util.*

@Mapper
interface RiskValueMapper : MyMapper<RiskValue?> {

    fun queryRiskDataByMonth(mnCode: String?, month: LocalDate?, type: String?): List<RiskValuePojo?>
}