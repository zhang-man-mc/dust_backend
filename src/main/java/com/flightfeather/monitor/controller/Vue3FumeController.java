package com.flightfeather.monitor.controller;

import com.flightfeather.monitor.pojo.*;
import com.flightfeather.monitor.service.Vue3FumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// FIXME: 2023/11/15 类名不合适, 各函数的分类不合适, 需要根据业务拆分成多个service
@Slf4j
@RequestMapping("/fume")
@CrossOrigin
@RestController
public class Vue3FumeController {
    @Autowired
    private Vue3FumeService vue3FumeService;


    //查询所有店铺的超标数据
    @GetMapping("/find")
    public Result findall(){
        List<FumeHistoryData> list = vue3FumeService.findall();
        return Result.success(list);
    }

    //条件组合查询油烟超标数据
    @GetMapping("/exceed")
    public Result conditonQueryExceedingData(String devId,String beginTime, String endTime ){
//        log.info("设备编号，{}",devId);
        List<FumeHistoryData> list = vue3FumeService.conditonQueryExceedingData(devId,beginTime,endTime);
        return Result.success(list);
    }
    //条件组合查询油烟历史数据
    @GetMapping("/history")
    public Result conditonQueryHistoryData(String devId,String beginTime, String endTime ){
        List<FumeHistoryData> list = vue3FumeService.conditonQueryHistoryData(devId,beginTime,endTime);
        return Result.success(list);
    }

    //放回设备信息表所有信息
    @GetMapping("/device")
    public Result allDeviceInfo(){
        List<DeviceInfo> list = vue3FumeService.allDeviceInfo();
        return Result.success(list);
    }

    //放回异常表所有数据
    @GetMapping("/abnormal")
    public Result allAbnormalData(){
        List<FumeAbnormalData> list = vue3FumeService.allAbnormalData();
        return Result.success(list);
    }

    //条件组合查询异常表数据
    @GetMapping("/abnormalone")
    public Result conditonQueryAbnormalData(String devId,String beginTime, String endTime ){
//        log.info("设备编号，{}",devId);
        List<FumeAbnormalData> list = vue3FumeService.conditonQueryAbnormalData(devId,beginTime,endTime);
        return Result.success(list);
    }

    //条件组合查询异常表  增加了异常类型选项
    @GetMapping("/abnormaltwo")
    public Result conditonQueryAbnormalData1(String devId,String exceptionValue,String beginTime, String endTime ){
//        log.info("设备编号，{}",devId);
//        log.info("异常类型选择为，{}",exceptionValue);
        List<FumeAbnormalData> list = vue3FumeService.conditonQueryAbnormalData1(devId,exceptionValue,beginTime,endTime);
        return Result.success(list);
    }

//    //根据异常类型返回店铺名称和设备编号 比如油烟超标对应的所有店铺名称和设备编号（已去除重复）
//    @GetMapping("/shopname")
//    public Result findShopName(String exceptionType){
////        log.info("异常类型选择为，{}",exceptionType);
//        List<FumeAbnormalData> list = vue3FumeService.findShopName(exceptionType);
//        return Result.success(list);
//    }


    //根据某段时间内某个异常类型查询对应的店铺名称和设备编号 比如1号到7号 ，油烟超标对应的所有店铺名称和设备编号（已去除重复）
    @GetMapping("/shopname")
    public Result findShopNameBYTime(String exceptionType,String beginTime,String endTime){
//        log.info("异常类型选择为，{}",exceptionType);
        List<FumeAbnormalData> list = vue3FumeService.findShopNameBYTime(exceptionType,beginTime,endTime);
        return Result.success(list);
    }


    @GetMapping("/export")
    public Result exportByShopName(String[] shops, String exportBeginTime, String exportEndTime ){
//        log.info("店铺选择为，{}",shops[1]);
        List<FumeHistoryData> list = vue3FumeService.exportByShopName(shops,exportBeginTime,exportEndTime);
        return Result.success(list);
    }

//    查询店铺最新的一条数据
    @GetMapping("/lastest")
    public Result findLaststById(String[] shops ){
//        log.info("店铺选择为，{}",shops);
        List<FumeHistoryData> list = vue3FumeService.findLaststById(shops);
        return Result.success(list);
    }

    //查找不同的异常类型  返回结果为不重复的异常类型
    @GetMapping("/exceptiontype")
    public Result findExceptionType(){
        List<FumeAbnormalData> list = vue3FumeService.findExceptionType();
        return Result.success(list);
    }

    //条件组合查询异常表  异常类型选项改为多选
    @GetMapping("/abnormalthree")
    public Result conditonQueryAbnormalData2(String devId,String[] exceptionValue,String beginTime, String endTime ){
        List<FumeAbnormalData> list = vue3FumeService.conditonQueryAbnormalData2(devId,exceptionValue,beginTime,endTime);
        return Result.success(list);
    }

    //条件组合查询异常表  异常类型选项改为多选 后端分页
    @GetMapping("/abnormalfour")
    public Result conditonQueryAbnormalData3(@RequestParam(defaultValue = "1") Integer page,
                                             @RequestParam(defaultValue = "10")Integer pageSize,
                                             String devId,String[] exceptionValue,String beginTime, String endTime ){
        PageBean pageBean = vue3FumeService.page(page,pageSize,devId,exceptionValue,beginTime,endTime);
        return Result.success(pageBean);
    }

//    返回异常表的最早和最晚时间
    @GetMapping("/time")
    public Result earlyAndLastTime(){
        List<FumeAbnormalData> list = vue3FumeService.earlyAndLastTime();
        return Result.success(list);
    }

//    返回可供爬取的店铺名称 （这些店铺名称有的是缩写的 对应与python编码 不能用MySQL其他表的店铺名代替）
    @GetMapping("/shopnamepy")
    public Result shopnamePythonUse(){
        List<FumeHistoryData> list = vue3FumeService.shopnamePythonUse();
        return Result.success(list);
    }


    //  返回历史数据表的距今的最新时间
    @GetMapping("/lastesttime")
    public Result lastestTimeFromHistoryData(){
        List<FumeHistoryData> list = vue3FumeService.lastestTimeFromHistoryData();
        return Result.success(list);
    }

//   根据时间返回该异常类型的个数
    @GetMapping("/exceptionnum")
    public Result exceptionNum(String exceptionType,String beginTime,String endTime){
        Integer list = vue3FumeService.exceptionNum( exceptionType, beginTime, endTime);
        return Result.success(list);
    }

}
