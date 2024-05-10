package com.flightfeather.monitor.service;

import com.flightfeather.monitor.pojo.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FugitiveDustService {

    PageBean page(Integer page, Integer pageSize, String siteName, String mnCode, String beginTime, String endTime, String[] scenarioType);

    List<DustSiteData> scenarioData();

    List<DustSiteData> allSiteName();

    List<AnalysisDustData> analysisdata(String siteName, String beginTime, String endTime, String type);

    List<AnalysisDustData> analysisByTime(String siteName, String beginTime, String endTime);

    PageBean pageAnalysisTime(Integer page, Integer pageSize, String siteName, String beginTime, String endTime, String orderProp,
                              Boolean asc);

    List<DustExceptionType> getExceptionType();


    PageBean getExceptionData(Integer page, Integer pageSize, String siteName, String[] exceptionType, String beginTime, String endTime);

    List<DustExceptionData> getExceptionSitenameAndCode(String exceptionType, String beginTime, String endTime, String[] street, String[] dutyCompany, String siteName);

    Integer exceptionNum(String exceptionType, String beginTime, String endTime, String[] street, String[] dutyCompany, String siteName);

    List<DustSiteData> conditonQueryHistoryData(String siteName, String beginTime, String endTime);

    List<DustExceptionData> getExceptionAllData(String siteName, String[] exceptionType, String beginTime, String endTime);

    List<DustExceptionData> exceptionSiteNum();

    List<AnalysisDustData> analysisAll(String siteName, String beginTime, String endTime);

    List<DustSiteData> conditonQueryhistoryallData(String siteName, String mnCode, String beginTime, String endTime, String[] scenarioType);

    /*新增审计信息*/
    void addAuditNotes(AuditInfo auditInfo);

    List<AuditInfo> getAuditAllData();

    void update(AuditInfo auditInfo);

    List<DustExceptionData> getHasAuditedData(String beginTime, String endTime);


    void setting(DustDataAccessSetting dustDataAccessSetting);

    List<DustExceptionData> getSiteNameByTimeAndExceptionType(String[] exceptionType, String beginTime, String endTime);

    List<AnalysisDustData> analysisdataByType(String month, String type);

    List<AnalysisDustData> analysisdataByTimeAndType(String beginTime, String endTime, String type);

    PageBean getExceptionData2(Integer page, Integer pageSize, String siteName, String[] exceptionType, String beginTime, String endTime, String[] street, String[] dutyCompany);
}
