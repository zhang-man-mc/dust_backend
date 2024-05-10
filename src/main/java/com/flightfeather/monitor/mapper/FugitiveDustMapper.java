package com.flightfeather.monitor.mapper;

import com.flightfeather.monitor.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FugitiveDustMapper{

    List<DustSiteData> conditonQueryDustHistoryData(String siteName, String mnCode,String beginTime, String endTime,@Param("scenarioType") String[] scenarioType) ;

    @Select("select DISTINCT typename from ja_t_dust_site_info")
    List<DustSiteData> scenarioData();

    @Select("select DISTINCT name,mn_code from ja_t_dust_site_info  ")
    List<DustSiteData> allSiteName();

    List<AnalysisDustData> analysisdata(String siteName, String beginTime, String endTime,String type);

    List<AnalysisDustData> analysisByTime(String siteName, String beginTime, String endTime);

    @Select("select DISTINCT exception,exception_type from dust_exception_data")
    List<DustExceptionType> getExceptionType();

    List<DustExceptionData> getExceptionData(String siteName,  @Param("exceptionType")String[] exceptionType, String beginTime, String endTime);

    List<DustExceptionData> getExceptionSitenameAndCode(String exceptionType, String beginTime, String endTime,@Param("street")String [] street,@Param("dutyCompany")String [] dutyCompany,String siteName);

    Integer exceptionNum(String exceptionType, String beginTime, String endTime,@Param("street")String [] street,@Param("dutyCompany")String [] dutyCompany,String siteName);

    List<DustSiteData> conditonQueryHistoryData(String siteName, String beginTime, String endTime);

    @Select("select DISTINCT mn_code from dust_exception_data")
    List<DustExceptionData> exceptionSiteNum();

    /*新增审计内容*/
    @Insert("insert into audit_info(exception_id,checker,checker_content,enterprise_content,audit_status,create_time,update_time) values(#{exceptionId},#{checker},#{checkerContent},#{enterpriseContent},#{auditStatus},#{createTime},#{updateTime})")
    void insert(AuditInfo auditInfo);

    @Select("select * from audit_info")
    List<AuditInfo> getAuditAllData();
    void update(AuditInfo auditInfo);


    List<DustExceptionData> getHasAuditedData(String beginTime, String endTime);

    @Insert("insert into dust_global_setting(user,create_time,begin_time,end_time,region,is_regular_time) values( #{user},#{createTime},#{beginTime},#{endTime},#{region},#{isRegularTime})")
    void setting(DustDataAccessSetting dustDataAccessSetting);


    List<DustExceptionData> getSiteNameByTimeAndExceptionType(@Param("exceptionType")String[] exceptionType, String beginTime, String endTime);

    List<AnalysisDustData> analysisdataByType(String month,String type);


    List<AnalysisDustData> analysisdataByTimeAndType(String beginTime, String endTime, String type);

    List<DustExceptionData> getExceptionData2(String siteName, @Param("exceptionType")String[] exceptionType, String beginTime, String endTime, @Param("street")String[] street, @Param("dutyCompany")String[] dutyCompany);
}
