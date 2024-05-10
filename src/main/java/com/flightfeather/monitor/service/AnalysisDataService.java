package com.flightfeather.monitor.service;

import com.flightfeather.monitor.pojo.AnalysisData;

import java.util.List;

public interface AnalysisDataService {
    List<AnalysisData> findAllData();

    List<AnalysisData> findByDevId(String devId,String begin, String end);


    List<AnalysisData> find(String shopname,String value,String begin, String end);

    void write(AnalysisData analysisData);

    List<AnalysisData> search(String shopname, String value,String begin, String end);
}
