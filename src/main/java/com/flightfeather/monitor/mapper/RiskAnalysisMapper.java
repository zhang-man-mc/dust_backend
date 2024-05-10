package com.flightfeather.monitor.mapper;

import com.flightfeather.monitor.domain.ds1.entity.RiskValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RiskAnalysisMapper {

    List<RiskValue> queryRiskDataByMonth(String siteName,String month, String type);
}
