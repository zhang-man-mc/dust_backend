package com.flightfeather.monitor.service.impl;

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting;
import com.flightfeather.monitor.domain.ds1.entity.RequestTaskSetting;
import com.flightfeather.monitor.domain.ds1.mapper.DustExceptionSettingMapper;
import com.flightfeather.monitor.service.ExceptionSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: ExceptionSettingImpl
 * @Description: TODO
 * @author: yourname
 */
@Slf4j
@Service
public class ExceptionSettingImpl implements ExceptionSettingService {
    @Autowired
    private DustExceptionSettingMapper dustExceptionSettingMapper;

    @Override
    public List<DustExceptionSetting> queryExceptionSettingData() {
        Example example = new Example(DustExceptionSetting.class);
        example.orderBy("updateTime").desc();
        List<DustExceptionSetting> list = dustExceptionSettingMapper.selectByExample(example);
        return list;
    }


    @Override
    public void addNewExceptionSetting(DustExceptionSetting dustExceptionSetting) {
        /*版本号加一*/
        dustExceptionSetting.setUpdateTime(new Date());
        double v = Double.parseDouble(dustExceptionSetting.getVersion()) + 1;
        dustExceptionSetting.setVersion(Double.toString(v));
        dustExceptionSettingMapper.insertSelective(dustExceptionSetting);
    }


    @Override
    public List<DustExceptionSetting> queryByVersion(String version) {
        Example example = new Example(DustExceptionSetting.class);
        example.createCriteria().andEqualTo("version", version);
        List<DustExceptionSetting> list = dustExceptionSettingMapper.selectByExample(example);
        return list;
    }


    @Override
    public void alertExceptionSetting(DustExceptionSetting dustExceptionSetting) {
        /*设置更新时间*/
        dustExceptionSetting.setUpdateTime(new Date());
        /* */
        Example example = new Example(RequestTaskSetting.class);
        example.createCriteria().andEqualTo("version", "1.0");
        dustExceptionSettingMapper.updateByExampleSelective(dustExceptionSetting, example);
    }
}
