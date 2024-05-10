package com.flightfeather.monitor.controller;


import com.flightfeather.monitor.pojo.*;
import com.flightfeather.monitor.service.FugitiveDustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequestMapping("/dust")
@CrossOrigin
@RestController
public class FugitiveDustController {
    @Autowired
    private FugitiveDustService fugitiveDustService;


    //扬尘 监测点历史数据  后端分页
    @GetMapping("/history1")
    public Result conditonQueryAbnormalData3(@RequestParam(defaultValue = "1") Integer page,
                                             @RequestParam(defaultValue = "20") Integer pageSize,
                                             String siteName, String mnCode, String beginTime, String endTime, String[] scenarioType) {
        PageBean pageBean = fugitiveDustService.page(page, pageSize, siteName, mnCode, beginTime, endTime, scenarioType);
        return Result.success(pageBean);
    }

    //    返回查询的所有历史数据
    @GetMapping("/historyall")
    public Result conditonQueryhistoryallData(String siteName, String mnCode, String beginTime, String endTime, String[] scenarioType) {
        List<DustSiteData> list = fugitiveDustService.conditonQueryhistoryallData(siteName, mnCode, beginTime, endTime, scenarioType);
        return Result.success(list);
    }

    //    返回监测点数据中的不同的场景
    @GetMapping("/scenario")
    public Result conditonQueryHistoryData() {
        List<DustSiteData> list = fugitiveDustService.scenarioData();
        return Result.success(list);
    }

    // 返回所有站点名字
    @GetMapping("/sitename")
    public Result allSiteName() {
        List<DustSiteData> list = fugitiveDustService.allSiteName();
        return Result.success(list);
    }

    //    根据站点名字和时间段查询均值和
    @GetMapping("/analysisdata")
    public Result analysisdata(String siteName, String beginTime, String endTime, String type) {
        List<AnalysisDustData> list = fugitiveDustService.analysisdata(siteName, beginTime, endTime, type);
        return Result.success(list);
    }

    //    根据站点名字和时段进行统计分析 后端分页
    @GetMapping("/analysistime")
    public Result analysisByTime(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "20") Integer pageSize,
            String siteName,
            String beginTime,
            String endTime,
            String orderProp,
            Boolean asc) {
        PageBean pageBean = fugitiveDustService.pageAnalysisTime(page, pageSize, siteName, beginTime, endTime,
                orderProp, asc);
        return Result.success(pageBean);
    }

    //动态计算分析数据  不分页
    @GetMapping("/analysisall")
    public Result analysisAll(String siteName, String beginTime, String endTime) {
        List<AnalysisDustData> list = fugitiveDustService.analysisAll(siteName, beginTime, endTime);
        return Result.success(list);
    }

    //获得不同的异常类型
    @GetMapping("/exceptiontype")
    public Result getExceptionType() {
        List<DustExceptionType> list = fugitiveDustService.getExceptionType();
        return Result.success(list);
    }


    //条件查询异常数据
    @GetMapping("/exceptiondata")
    public Result getExceptionData(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "20") Integer pageSize, String siteName, String[] exceptionType, String beginTime, String endTime) {
        PageBean pageBean = fugitiveDustService.getExceptionData(page, pageSize, siteName, exceptionType, beginTime, endTime);
        return Result.success(pageBean);
    }


    //条件查询异常数据 不分页
    @GetMapping("/exceptiondata1")
    public Result getExceptionAllData(String siteName, String[] exceptionType, String beginTime, String endTime) {
        List<DustExceptionData> list = fugitiveDustService.getExceptionAllData(siteName, exceptionType, beginTime, endTime);
        return Result.success(list);
    }

    //增加街道和运维商 条件查询异常数据
    @GetMapping("/exceptiondata2")
    public Result getExceptionData2(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "20") Integer pageSize, String siteName, String[] exceptionType, String beginTime, String endTime, String[] street, String[] dutyCompany) {
        PageBean pageBean = fugitiveDustService.getExceptionData2(page, pageSize, siteName, exceptionType, beginTime, endTime, street, dutyCompany);
        return Result.success(pageBean);
    }

    //根据某段时间内某个异常类型,地址，运维商，点位名称  ，查询对应的店铺名称和设备编号
    @GetMapping("/sitenamecode")
    public Result getExceptionSitenameAndCode(String exceptionType, String beginTime, String endTime, String[] street, String[] dutyCompany, String siteName) {
        List<DustExceptionData> list = fugitiveDustService.getExceptionSitenameAndCode(exceptionType, beginTime, endTime, street, dutyCompany, siteName);
        return Result.success(list);
    }


    //   根据时间,地址，运维商，点位名称，返回该异常类型的个数
    @GetMapping("/exceptionnum")
    public Result exceptionNum(String exceptionType, String beginTime, String endTime, String[] street, String[] dutyCompany, String siteName) {
        Integer list = fugitiveDustService.exceptionNum(exceptionType, beginTime, endTime, street, dutyCompany, siteName);
        return Result.success(list);
    }


    //    查询历史数据 不分页
    @GetMapping("/history")
    public Result conditonQueryHistoryData(String siteName, String beginTime, String endTime) {
        List<DustSiteData> list = fugitiveDustService.conditonQueryHistoryData(siteName, beginTime, endTime);
        return Result.success(list);
    }

    //   返回异常的店铺总数

    @GetMapping("/exceptionsitenum")
    public Result exceptionSiteNum() {
        List<DustExceptionData> list = fugitiveDustService.exceptionSiteNum();
        return Result.success(list);
    }

    /*新增审计内容*/
    @PostMapping("/audit")
    public Result addAuditNotes(@RequestBody AuditInfo auditInfo) {
        fugitiveDustService.addAuditNotes(auditInfo);
        return Result.success();
    }

    /*返回审核表所有数据*/
    @PostMapping("/auditAllData")
    public Result getAuditAllData() {
        List<AuditInfo> list = fugitiveDustService.getAuditAllData();
        return Result.success(list);
    }

    /*更新异常表格*/
    @PutMapping("/auditUpdate")
    public Result getAuditAllData(@RequestBody AuditInfo auditInfo) {
        fugitiveDustService.update(auditInfo);
        return Result.success();
    }

    /*根据异常时间返回时间内已审核的异常*/
    @GetMapping("/auditnum")
    public Result getHasAuditedData(String beginTime, String endTime) {
        List<DustExceptionData> list = fugitiveDustService.getHasAuditedData(beginTime, endTime);
        return Result.success(list);
    }

    /*写入用户的全局配置*/
    @PostMapping("setting")
    public Result setting(@RequestBody DustDataAccessSetting dustDataAccessSetting) {
        fugitiveDustService.setting(dustDataAccessSetting);
        return Result.success();
    }


    /*根据异常类型和时段 返回站点名字*/
    @GetMapping("/exceptionsSiteName")
    public Result getSiteNameByTimeAndExceptionType(String[] exceptionType, String beginTime, String endTime) {
        List<DustExceptionData> list = fugitiveDustService.getSiteNameByTimeAndExceptionType(exceptionType, beginTime, endTime);
        return Result.success(list);
    }


    @GetMapping("/analysisdataByType")
    public Result analysisdataByType(String month, String type) {
        List<AnalysisDustData> list = fugitiveDustService.analysisdataByType(month, type);
        return Result.success(list);
    }


    @GetMapping("/analysisdataByTimeAndType")
    public Result analysisdataByTimeAndType(String beginTime, String endTime, String type) {
        List<AnalysisDustData> list = fugitiveDustService.analysisdataByTimeAndType(beginTime, endTime, type);
        return Result.success(list);
    }




}
