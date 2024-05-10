package com.flightfeather.monitor.service;

import com.flightfeather.monitor.domain.ds1.entity.RiskValue;
import com.flightfeather.monitor.pojo.RiskValuePojo;

import java.util.List;

public interface RiskValueService {
    /**
     * 根据站点名字（可选值），月份，类型来返回风险值
     * @param mnCode
     * @param month
     * @param type
     * @return
     */
    List<RiskValuePojo> queryRiskDataByMonth(String mnCode, String month, String type);
}
