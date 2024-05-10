package com.flightfeather.monitor.mapper;

import com.flightfeather.monitor.pojo.DeviceInfo;
import com.flightfeather.monitor.pojo.FumeAbnormalData;
import com.flightfeather.monitor.pojo.FumeHistoryData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



import java.util.List;

@Mapper
public interface Vue3FumeMapper {

    //两张表联合查询
    @Select("select a.MV_ID,a.MV_Stat_Code,b.DI_Name,a.MV_Create_Time,a.MV_Data_Time,a.MV_Fume_Concentration2\n" +
            "from fd_t_minutevalue as a join ea_t_device_info as b on a.MV_Stat_Code = b.DI_Code ")
    List<FumeHistoryData> findall();

    List<FumeHistoryData> conditionQuery(String devId, String beginTime, String endTime);

    List<FumeHistoryData> conditionQueryHistory(String devId, String beginTime, String endTime);



    //返回设备信息表所有数据
    @Select("select * from ea_t_device_info")
    List<DeviceInfo> allDeviceInfo();

    @Select("select a1.dev_id,b.DI_Name,a1.exception,a1.exception_type,a1.region,a1.begin_time,a1.end_time\n" +
            "from abnormal_data as a1 join ea_t_device_info as b on  a1.dev_id =  b.DI_Code\n")
    List<FumeAbnormalData> allAbnormalData();

    List<FumeAbnormalData> conditonQueryAbnormalData(String devId, String beginTime, String endTime);

    List<FumeAbnormalData> conditonQueryAbnormalData1(String devId, String exceptionValue, String beginTime, String endTime);

    //返回该异常类型对应的店铺名和设备编号
    @Select("select DISTINCT b1.DI_Name,a1.dev_id\n" +
            "from abnormal_data as a1 join ea_t_device_info as b1 on a1.dev_id = b1.DI_Code\n" +
            "where a1.exception_type = #{exceptionType}")
    List<FumeAbnormalData> findShopName(String exceptionType);

    List<FumeHistoryData> exportByShopName(@Param("a") String[] shops, String exportBeginTime, String exportEndTime);



    //返回某设备的最新一条油烟数据
    List<FumeHistoryData> findLaststById(@Param("shops") String[] shops);


    //只返回不同的异常类型
    @Select("select distinct exception_type from abnormal_data order by exception_type")
    List<FumeAbnormalData> findExceptionType();

    List<FumeAbnormalData> conditonQueryAbnormalData2(String devId, @Param("exceptionValue") String[] exceptionValue, String beginTime, String endTime);

    List<FumeAbnormalData> conditonQueryAbnormalData3(String devId,@Param("exceptionValue") String[] exceptionValue, String beginTime, String endTime);

    List<FumeAbnormalData> findShopNameBYTime(String exceptionType, String beginTime, String endTime);
    @Select("select min(begin_time) as begin_time,max(end_time) as end_time from abnormal_data ")
    List<FumeAbnormalData> earlyAndLastTime();


    @Select("select max(MV_Data_Time) as MV_Data_Time from fd_t_minutevalue")
    List<FumeHistoryData> lastestTimeFromHistoryData();

    @Select("select * from shop_names order by MV_ID")
    List<FumeHistoryData> shopnamePythonUse();





    @Select("select count(*) from abnormal_data where exception_type = #{exceptionType} and (begin_time between #{beginTime} and #{endTime} or end_time between #{beginTime} and #{endTime})")
    Integer exceptionNum(String exceptionType, String beginTime, String endTime);


//    返回设备信息表的条数
//    @Select("SELECT count(*) from ea_t_device_info")
//    String shopNum();
}
