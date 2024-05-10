package com.flightfeather.monitor.controller.dust;

import com.flightfeather.monitor.domain.ds1.entity.RequestTaskSetting;
import com.flightfeather.monitor.pojo.Result;
import com.flightfeather.monitor.service.RequestSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: RequestSettingController
 * @Description: TODO
 * @author: yourname
 */

@Slf4j
@RestController
@RequestMapping("/dust/request")
@CrossOrigin
public class RequestSettingController {
    @Autowired
    private RequestSettingService requestSettingService;

    /*查询数据请求配置表的所有数据  结果是按更新时间 降序排列*/
    @GetMapping("/querySetting")
    public Result queryRequestSettingData() {
        List<RequestTaskSetting> list = requestSettingService.queryRequestSettingData();
        return Result.success(list);
    }

    /*根据版本号 查询*/
    @GetMapping("/byVersion")
    public Result queryByVersion(String version) {
        if (version == "" || version == null) {
            return Result.error("版本号不能为空！");
        }

        List<RequestTaskSetting> list = requestSettingService.queryByVersion(version);
        return Result.success(list);
    }

    /*修改数据请求的配置*/
    @PostMapping("/alertSetting")
    public Result alertRequestSetting(@RequestBody RequestTaskSetting requestTaskSetting) {
        requestSettingService.alertRequestSetting(requestTaskSetting);
        return Result.success();
    }

    /*新增数据请求的配置*/
    @PostMapping("/addSetting")
    public Result addNewRequestSetting(@RequestBody RequestTaskSetting requestTaskSetting) {
        requestSettingService.addNewRequestSetting(requestTaskSetting);
        return Result.success();
    }


}
