package com.flightfeather.monitor.service.impl;

import com.flightfeather.monitor.domain.ds1.entity.RiskValue;
import com.flightfeather.monitor.domain.ds1.mapper.RiskValueMapper;
import com.flightfeather.monitor.domain.ds1.repository.RiskValueRep;
import com.flightfeather.monitor.mapper.RiskAnalysisMapper;
import com.flightfeather.monitor.pojo.RiskValuePojo;
import com.flightfeather.monitor.service.RiskValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RiskValueServiceImpl implements RiskValueService {
    @Autowired
    private RiskValueMapper riskValueMapper;
    @Autowired
    private RiskValueRep riskValueRep;

    @Override
    public List<RiskValuePojo> queryRiskDataByMonth(String mnCode, String month, String type) {
        LocalDate date = LocalDate.parse(month);
        if (date != null) {
            date = date.withDayOfMonth(1);
            List<RiskValuePojo> res = riskValueMapper.queryRiskDataByMonth(mnCode, date, type);
            return res;
//            return riskValueRep.select(mnCode, date, type);
        } else {
            return new ArrayList<>();
        }
    }
}
