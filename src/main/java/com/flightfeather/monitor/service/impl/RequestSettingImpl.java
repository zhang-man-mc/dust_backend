package com.flightfeather.monitor.service.impl;

import com.flightfeather.monitor.domain.ds1.entity.RequestTaskSetting;
import com.flightfeather.monitor.domain.ds1.mapper.RequestTaskSettingMapper;
import com.flightfeather.monitor.service.RequestSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: RequestSettingImpl
 * @Description: TODO
 * @author: yourname
 */
@Slf4j
@Service
public class RequestSettingImpl implements RequestSettingService {

    @Autowired
    private RequestTaskSettingMapper requestTaskSettingMapper;

    @Override
    public List<RequestTaskSetting> queryRequestSettingData() {
        Example example = new Example(RequestTaskSetting.class);
        example.orderBy("updateTime").desc();
        List<RequestTaskSetting> list = requestTaskSettingMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<RequestTaskSetting> queryByVersion(String version) {
        Example example = new Example(RequestTaskSetting.class);
        example.createCriteria().andEqualTo("version", version);
        List<RequestTaskSetting> list = requestTaskSettingMapper.selectByExample(example);
        return list;
    }


    @Override
    public void alertRequestSetting(RequestTaskSetting requestTaskSetting) {
        /*设置更新时间*/
        requestTaskSetting.setUpdateTime(new Date());
        /*获取频率 换算成秒*/
        requestTaskSetting.setRequestIntervalSeconds(requestTaskSetting.getRequestIntervalSeconds() * 3600);

        Example example = new Example(RequestTaskSetting.class);
        example.createCriteria().andEqualTo("version", "1.0");
        requestTaskSettingMapper.updateByExampleSelective(requestTaskSetting, example);

    }


    @Override
    public void addNewRequestSetting(RequestTaskSetting requestTaskSetting) {
        /*设置更新时间*/
        requestTaskSetting.setUpdateTime(new Date());
        /*版本号加一*/
        double v = Double.parseDouble(requestTaskSetting.getVersion()) + 1;
        requestTaskSetting.setVersion(Double.toString(v));
        /*获取频率 换算成秒*/
        requestTaskSetting.setRequestIntervalSeconds(requestTaskSetting.getRequestIntervalSeconds() * 3600);
        requestTaskSettingMapper.insertSelective(requestTaskSetting);
    }


}
