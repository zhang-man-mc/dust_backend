package com.flightfeather.monitor.service.impl;

import com.flightfeather.monitor.domain.ds1.mapper.DustStatisticsValueMapper;
import com.flightfeather.monitor.mapper.FugitiveDustMapper;
import com.flightfeather.monitor.pojo.*;
import com.flightfeather.monitor.service.FugitiveDustService;
import com.flightfeather.monitor.utils.StringUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class FugitiveDustServiceImpl implements FugitiveDustService {

    @Autowired
    private FugitiveDustMapper fugitiveDustMapper;

    @Autowired
    private DustStatisticsValueMapper dustStatisticsValueMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String siteName, String mnCode, String beginTime, String endTime, String[] scenarioType) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询
        List<DustSiteData> infoList = fugitiveDustMapper.conditonQueryDustHistoryData(siteName, mnCode, beginTime, endTime, scenarioType);
        //获取查询结果
        Page<DustSiteData> p = (Page<DustSiteData>) infoList;

        //封装PageBean对象*/
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public List<DustSiteData> scenarioData() {
        List<DustSiteData> list = fugitiveDustMapper.scenarioData();
        return list;
    }

    @Override
    public List<DustSiteData> allSiteName() {
        List<DustSiteData> list = fugitiveDustMapper.allSiteName();
        return list;
    }

    @Override
    public List<AnalysisDustData> analysisdata(String siteName, String beginTime, String endTime, String type) {
        List<AnalysisDustData> list = fugitiveDustMapper.analysisdata(siteName, beginTime, endTime, type);
        return list;
    }

    @Override
    public List<AnalysisDustData> analysisByTime(String siteName, String beginTime, String endTime) {
        List<AnalysisDustData> list = fugitiveDustMapper.analysisByTime(siteName, beginTime, endTime);
        return list;
    }

    @Override
    public PageBean pageAnalysisTime(Integer page, Integer pageSize, String siteName, String beginTime,
                                     String endTime, String orderProp,
                                     Boolean asc) {
        //设置分页参数
        Page<AnalysisDustData> p = PageHelper.startPage(page, pageSize);
        //获取查询结果
        String prop = StringUtil.INSTANCE.camelCaseToUnderline(orderProp);
        dustStatisticsValueMapper.selectByOrder(siteName, beginTime, endTime, prop, asc);

        //封装PageBean对象
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public List<DustExceptionType> getExceptionType() {
        List<DustExceptionType> list = fugitiveDustMapper.getExceptionType();
        return list;
    }

    @Override
    public PageBean getExceptionData(Integer page, Integer pageSize, String siteName, String[] exceptionType, String beginTime, String endTime) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);

        List<DustExceptionData> infoList = fugitiveDustMapper.getExceptionData(siteName, exceptionType, beginTime, endTime);
        //获取查询结果
        Page<DustExceptionData> p = (Page<DustExceptionData>) infoList;

        //封装PageBean对象*/
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        return pageBean;
    }

    @Override
    public List<DustExceptionData> getExceptionSitenameAndCode(String exceptionType, String beginTime, String endTime, String[] street, String[] dutyCompany, String siteName) {
        List<DustExceptionData> list = fugitiveDustMapper.getExceptionSitenameAndCode(exceptionType, beginTime, endTime, street, dutyCompany, siteName);
        return list;
    }

    @Override
    public Integer exceptionNum(String exceptionType, String beginTime, String endTime, String[] street, String[] dutyCompany, String siteName) {
        Integer list = fugitiveDustMapper.exceptionNum(exceptionType, beginTime, endTime, street, dutyCompany, siteName);
        return list;
    }

    @Override
    public List<DustSiteData> conditonQueryHistoryData(String siteName, String beginTime, String endTime) {
        List<DustSiteData> list = fugitiveDustMapper.conditonQueryHistoryData(siteName, beginTime, endTime);
        return list;
    }

    @Override
    public List<DustExceptionData> getExceptionAllData(String siteName, String[] exceptionType, String beginTime, String endTime) {
        List<DustExceptionData> list = fugitiveDustMapper.getExceptionData(siteName, exceptionType, beginTime, endTime);
        return list;
    }

    @Override
    public List<DustExceptionData> exceptionSiteNum() {
        List<DustExceptionData> list = fugitiveDustMapper.exceptionSiteNum();
        return list;
    }

    @Override
    public List<AnalysisDustData> analysisAll(String siteName, String beginTime, String endTime) {
        List<AnalysisDustData> list = fugitiveDustMapper.analysisByTime(siteName, beginTime, endTime);
        return list;
    }

    @Override
    public List<DustSiteData> conditonQueryhistoryallData(String siteName, String mnCode, String beginTime, String endTime, String[] scenarioType) {
        List<DustSiteData> list = fugitiveDustMapper.conditonQueryDustHistoryData(siteName, mnCode, beginTime, endTime, scenarioType);
        return list;
    }

    @Override
    public void addAuditNotes(AuditInfo auditInfo) {
        if (auditInfo.getAuditStatus() == 3) {
            auditInfo.setUpdateTime(LocalDateTime.now());
            auditInfo.setCreateTime(LocalDateTime.now());
        } else {
            auditInfo.setCreateTime(LocalDateTime.now());

        }
        fugitiveDustMapper.insert(auditInfo);
    }

    @Override
    public List<AuditInfo> getAuditAllData() {
        List<AuditInfo> list = fugitiveDustMapper.getAuditAllData();
        return list;
    }

    @Override
    public void update(AuditInfo auditInfo) {
        auditInfo.setUpdateTime(LocalDateTime.now());
        fugitiveDustMapper.update(auditInfo);
    }


    @Override
    public List<DustExceptionData> getHasAuditedData(String beginTime, String endTime) {
        List<DustExceptionData> list = fugitiveDustMapper.getHasAuditedData(beginTime, endTime);
        return list;
    }

    @Override
    public void setting(DustDataAccessSetting dustDataAccessSetting) {
        dustDataAccessSetting.setCreateTime(LocalDateTime.now());
        fugitiveDustMapper.setting(dustDataAccessSetting);
    }

    @Override
    public List<DustExceptionData> getSiteNameByTimeAndExceptionType(String[] exceptionType, String beginTime, String endTime) {
        List<DustExceptionData> list = fugitiveDustMapper.getSiteNameByTimeAndExceptionType(exceptionType, beginTime, endTime);
        return list;
    }

    @Override
    public List<AnalysisDustData> analysisdataByType(String month, String type) {
        List<AnalysisDustData> list = fugitiveDustMapper.analysisdataByType(month, type);
        return list;
    }

    @Override
    public List<AnalysisDustData> analysisdataByTimeAndType(String beginTime, String endTime, String type) {
        List<AnalysisDustData> list = fugitiveDustMapper.analysisdataByTimeAndType(beginTime, endTime, type);
        return list;
    }

    @Override
    public PageBean getExceptionData2(Integer page, Integer pageSize, String siteName, String[] exceptionType, String beginTime, String endTime, String[] street, String[] dutyCompany) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);

        List<DustExceptionData> infoList = fugitiveDustMapper.getExceptionData2(siteName, exceptionType, beginTime, endTime, street, dutyCompany);
        //获取查询结果
        Page<DustExceptionData> p = (Page<DustExceptionData>) infoList;

        //封装PageBean对象*/
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        return pageBean;
    }


}
