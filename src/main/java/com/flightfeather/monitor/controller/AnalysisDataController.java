package com.flightfeather.monitor.controller;

import com.flightfeather.monitor.pojo.AnalysisData;
import com.flightfeather.monitor.pojo.Result;
import com.flightfeather.monitor.service.AnalysisDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/data")
@CrossOrigin
public class AnalysisDataController {
    @Autowired
    private AnalysisDataService analysisDataService;

    @GetMapping("/all")
    public Result findAllData(){
        List<AnalysisData> list =analysisDataService.findAllData();
        return Result.success(list);
    }

    //ed_dataa数据库
    @GetMapping("/id")
    public Result findByDevId(String devId,String begin, String end){
        String begin1=begin;
        String end1=end;
        List<AnalysisData> listId=analysisDataService.findByDevId(devId,begin,end);
        return Result.success(listId);
    }

    //店铺名，开始 结束时间查找  ed_data
    @GetMapping("/input")
    public Result find(String shopname,String value,String begin, String end){
        String begin1=begin;
        String end1=end;
        List<AnalysisData> listId=analysisDataService.find(shopname,value,begin,end) ;
        return Result.success(listId);
    }


    //分析爬取的数据   from_web_analysis_data数据库
    @PostMapping("/tosql")
    public Result find(@RequestBody AnalysisData analysisData){
        log.info("写入数据库中｛｝",analysisData);
        //调用service层写入
        analysisDataService.write(analysisData);
        return Result.success();
    }


    //去重  对from_web_analysis_data数据库
    @GetMapping("/search")
    public Result search(String shopname,String value,String begin, String end){
        List<AnalysisData> list=analysisDataService.search(shopname,value,begin,end);
        return Result.success(list);
    }

}
