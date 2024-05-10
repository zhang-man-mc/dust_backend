package com.flightfeather.monitor.service;

import com.flightfeather.monitor.pojo.DeviceInfo;
import com.flightfeather.monitor.pojo.FumeAbnormalData;
import com.flightfeather.monitor.pojo.FumeHistoryData;
import com.flightfeather.monitor.pojo.PageBean;

import java.util.List;


public interface Vue3FumeService {

    List<FumeHistoryData> findall();

    List<FumeHistoryData> conditonQueryExceedingData(String devId, String beginTime, String endTime);

    List<FumeHistoryData> conditonQueryHistoryData(String devId, String beginTime, String endTime);

    List<DeviceInfo> allDeviceInfo();

    List<FumeAbnormalData> allAbnormalData();

    List<FumeAbnormalData> conditonQueryAbnormalData(String devId, String beginTime, String endTime);

    List<FumeAbnormalData> conditonQueryAbnormalData1(String devId, String exceptionValue, String beginTime, String endTime);

    List<FumeAbnormalData> findShopName(String exceptionType);

    List<FumeHistoryData> exportByShopName(String[] shops, String exportBeginTime, String exportEndTime);

    List<FumeHistoryData> findLaststById(String[] shops);

    List<FumeAbnormalData> findExceptionType();

    List<FumeAbnormalData> conditonQueryAbnormalData2(String devId, String[] exceptionValue, String beginTime, String endTime);

    PageBean page(Integer page, Integer pageSize, String devId, String[] exceptionValue, String beginTime, String endTime);

    List<FumeAbnormalData> findShopNameBYTime(String exceptionType, String beginTime, String endTime);

    List<FumeAbnormalData>  earlyAndLastTime();

    List<FumeHistoryData> lastestTimeFromHistoryData();

    List<FumeHistoryData> shopnamePythonUse();

    Integer exceptionNum(String exceptionType, String beginTime, String endTime);


//    String shopNum();
}
