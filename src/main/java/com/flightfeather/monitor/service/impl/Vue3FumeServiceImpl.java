package com.flightfeather.monitor.service.impl;

import com.flightfeather.monitor.mapper.Vue3FumeMapper;
import com.flightfeather.monitor.pojo.DeviceInfo;
import com.flightfeather.monitor.pojo.FumeAbnormalData;
import com.flightfeather.monitor.pojo.FumeHistoryData;
import com.flightfeather.monitor.pojo.PageBean;
import com.flightfeather.monitor.service.Vue3FumeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class Vue3FumeServiceImpl implements Vue3FumeService {
    @Autowired
    private Vue3FumeMapper vue3FumeMapper;

    @Override
    public List<FumeHistoryData> findall() {
       List<FumeHistoryData> list = vue3FumeMapper.findall();
       return list;
    }

    @Override
    public List<FumeHistoryData> conditonQueryExceedingData(String devId, String beginTime, String endTime) {
        List<FumeHistoryData> list = vue3FumeMapper.conditionQuery(devId,beginTime,endTime);
        return list;
    }

    @Override
    public List<FumeHistoryData> conditonQueryHistoryData(String devId, String beginTime, String endTime) {
        List<FumeHistoryData> list = vue3FumeMapper.conditionQueryHistory(devId,beginTime,endTime);
        return list;
    }

    @Override
    public List<DeviceInfo> allDeviceInfo() {
       List<DeviceInfo> list = vue3FumeMapper.allDeviceInfo();
        return list;
    }

    @Override
    public List<FumeAbnormalData> allAbnormalData() {
       List<FumeAbnormalData> list = vue3FumeMapper.allAbnormalData();
        return list;
    }

    @Override
    public List<FumeAbnormalData> conditonQueryAbnormalData(String devId, String beginTime, String endTime) {
         List<FumeAbnormalData> list = vue3FumeMapper.conditonQueryAbnormalData(devId,beginTime,endTime);
        return list;
    }

    @Override
    public List<FumeAbnormalData> conditonQueryAbnormalData1(String devId, String exceptionValue, String beginTime, String endTime) {
        List<FumeAbnormalData> list = vue3FumeMapper.conditonQueryAbnormalData1(devId,exceptionValue,beginTime,endTime);
        return list;
    }

    @Override
    public List<FumeAbnormalData> findShopName(String exceptionType) {
        List<FumeAbnormalData> list = vue3FumeMapper.findShopName(exceptionType);
        return list;
    }

    @Override
    public List<FumeHistoryData> exportByShopName(String[] shops, String exportBeginTime, String exportEndTime) {
        List<FumeHistoryData> list = vue3FumeMapper.exportByShopName(shops,exportBeginTime,exportEndTime);
        return list;
    }

    @Override
    public List<FumeHistoryData> findLaststById(String[] shops) {
        List<FumeHistoryData> list = vue3FumeMapper.findLaststById(shops);
        return list;
    }

    @Override
    public List<FumeAbnormalData> findExceptionType() {
        List<FumeAbnormalData> list = vue3FumeMapper.findExceptionType();
        return list;
    }

    @Override
    public List<FumeAbnormalData> conditonQueryAbnormalData2(String devId, String[] exceptionValue, String beginTime, String endTime) {
        List<FumeAbnormalData> list = vue3FumeMapper.conditonQueryAbnormalData2(devId,exceptionValue,beginTime,endTime);
        return list;
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String devId, String[] exceptionValue, String beginTime, String endTime) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<FumeAbnormalData> infoList=vue3FumeMapper.conditonQueryAbnormalData3(devId,exceptionValue,beginTime,endTime);
        //获取查询结果
        Page<FumeAbnormalData> p=(Page<FumeAbnormalData>)infoList;
//        log.info("分页查询结果为：{}",p.getResult());
        //封装PageBean对象*/
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;

    }

    @Override
    public List<FumeAbnormalData> findShopNameBYTime(String exceptionType, String beginTime, String endTime) {
        List<FumeAbnormalData> list = vue3FumeMapper.findShopNameBYTime(exceptionType,beginTime,endTime);
        return list;
    }

    @Override
    public List<FumeAbnormalData>  earlyAndLastTime() {
        List<FumeAbnormalData> list = vue3FumeMapper.earlyAndLastTime();
        return list;
    }

    @Override
    public List<FumeHistoryData> lastestTimeFromHistoryData() {
        List<FumeHistoryData> list = vue3FumeMapper.lastestTimeFromHistoryData();
        return list;
    }

    @Override
    public List<FumeHistoryData> shopnamePythonUse() {
        List<FumeHistoryData> list = vue3FumeMapper.shopnamePythonUse();
        return list;
    }

    @Override
    public Integer exceptionNum(String exceptionType, String beginTime, String endTime) {
        Integer list = vue3FumeMapper.exceptionNum(exceptionType,beginTime,endTime);
        return list;
    }
}
