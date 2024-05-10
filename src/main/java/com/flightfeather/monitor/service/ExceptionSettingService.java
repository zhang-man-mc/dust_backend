package com.flightfeather.monitor.service;

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting;
import com.flightfeather.monitor.domain.ds1.entity.RequestTaskSetting;

import java.util.List;

public interface ExceptionSettingService {
    List<DustExceptionSetting> queryExceptionSettingData();

    void addNewExceptionSetting(DustExceptionSetting dustExceptionSetting);

    List<DustExceptionSetting> queryByVersion(String version);

    void alertExceptionSetting(DustExceptionSetting dustExceptionSetting);
}
