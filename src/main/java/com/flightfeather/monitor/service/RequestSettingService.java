package com.flightfeather.monitor.service;

import com.flightfeather.monitor.domain.ds1.entity.RequestTaskSetting;

import java.util.List;

public interface RequestSettingService {

    void addNewRequestSetting(RequestTaskSetting requestTaskSetting);

    List<RequestTaskSetting> queryRequestSettingData();

    List<RequestTaskSetting> queryByVersion(String version);

    void alertRequestSetting(RequestTaskSetting requestTaskSetting);
}
