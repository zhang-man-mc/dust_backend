package com.flightfeather.monitor.controller.dust;


import com.flightfeather.monitor.domain.ds1.entity.RiskValue;
import com.flightfeather.monitor.pojo.Result;
import com.flightfeather.monitor.pojo.RiskValuePojo;
import com.flightfeather.monitor.service.RiskValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dust/risk")
@CrossOrigin
public class RiskValueController {
    @Autowired
    private RiskValueService riskValueService;


    /**
     * 根据站点名字（可选值），月份，类型来返回风险值
     *
     * @param mnCode
     * @param month
     * @param type
     * @return
     */
    @GetMapping("/month")
    public Result queryRiskDataByMonth(
            @RequestParam(required = false) String mnCode,
            @RequestParam String month,
            @RequestParam String type
    ) {
        List<RiskValuePojo> list = riskValueService.queryRiskDataByMonth(mnCode, month, type);
        return Result.success(list);
    }
}
