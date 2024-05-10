package com.flightfeather.monitor.controller.dust;
import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting;
import com.flightfeather.monitor.domain.ds1.entity.RequestTaskSetting;
import com.flightfeather.monitor.pojo.Result;
import com.flightfeather.monitor.service.ExceptionSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: ExceptionSettingController
 * @Description: TODO
 * @author: yourname
 */
@Slf4j
@RestController
@RequestMapping("/dust/exception")
@CrossOrigin
public class ExceptionSettingController {
    @Autowired
    private ExceptionSettingService exceptionSettingService;

    /*查询异常分析配置表的所有数据  结果是按更新时间 降序排列*/
    @GetMapping("/querySetting")
    public Result queryRequestSettingData(){
        List<DustExceptionSetting> list = exceptionSettingService.queryExceptionSettingData();
        return Result.success(list);
    }

    /*根据版本号 查询*/
    @GetMapping("/byVersion")
    public Result queryByVersion(String version) {
        if (version == "" || version == null) {
            return Result.error("版本号不能为空！");
        }

        List<DustExceptionSetting> list = exceptionSettingService.queryByVersion(version);
        return Result.success(list);
    }


    /*修改数据请求的配置*/
    @PostMapping("/alertSetting")
    public Result alertRequestSetting(@RequestBody DustExceptionSetting dustExceptionSetting) {
        exceptionSettingService.alertExceptionSetting(dustExceptionSetting);
        return Result.success();
    }

    /*新增异常分析的配置*/
    @PostMapping("/addSetting")
    public Result addNewRequestSetting(@RequestBody DustExceptionSetting dustExceptionSetting){
        exceptionSettingService.addNewExceptionSetting(dustExceptionSetting);
        return Result.success();
    }

}
