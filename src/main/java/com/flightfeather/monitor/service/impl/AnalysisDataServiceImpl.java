package com.flightfeather.monitor.service.impl;

import com.flightfeather.monitor.mapper.AnalysisDataMapper;
import com.flightfeather.monitor.service.AnalysisDataService;
import com.flightfeather.monitor.pojo.AnalysisData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AnalysisDataServiceImpl implements AnalysisDataService {
    @Autowired
    private AnalysisDataMapper analysisDataMapper;

    @Override
    public List<AnalysisData> findAllData() {
       List<AnalysisData> list= analysisDataMapper.findAllData();
        return list;
    }

    //根据设备编号查找
    @Override
    public List<AnalysisData> findByDevId(String devId,String begin, String end) {
        List<AnalysisData> listId=analysisDataMapper.findByDevId(devId,begin,end);
        return listId;
    }

    @Override
    public List<AnalysisData> find(String shopname,String value,String begin, String end) {
        List<AnalysisData> list=analysisDataMapper.find(shopname,value,begin,end);
        return list;
    }

    @Override
    public void write(AnalysisData analysisData) {
        analysisDataMapper.write(analysisData);
    }

    @Override
    public  List<AnalysisData> search(String shopname, String value ,String begin, String end) {
        List<AnalysisData> list=analysisDataMapper.search(shopname,value,begin,end);
        return list;
    }


}
