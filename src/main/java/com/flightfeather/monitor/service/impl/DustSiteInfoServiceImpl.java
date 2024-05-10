package com.flightfeather.monitor.service.impl;

import com.flightfeather.monitor.domain.ds1.entity.DustSiteInfo;
import com.flightfeather.monitor.domain.ds1.mapper.DustSiteInfoMapper;
import com.flightfeather.monitor.service.DustSiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DustSiteInfoServiceImpl implements DustSiteInfoService {

    @Autowired
    private DustSiteInfoMapper dustSiteInfoMapper;
    @Override
    public List<DustSiteInfo> querySiteInfoBymnCode(String mnCode) {

        Example example = new Example(DustSiteInfo.class);
        example.createCriteria().andEqualTo("mnCode",mnCode);
        List<DustSiteInfo> list  = dustSiteInfoMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<DustSiteInfo> queryAllDutyCompany() {
        Example example = new Example(DustSiteInfo.class);
        example.setDistinct(true);
        example.selectProperties("dutyCompany");
        List<DustSiteInfo> list  = dustSiteInfoMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<DustSiteInfo> queryStreet(String street) {
        Example example = new Example(DustSiteInfo.class);
        example.setDistinct(true);
        example.selectProperties("address");
        example.createCriteria().andLike("address","%"+street+"%");
        List<DustSiteInfo> list  = dustSiteInfoMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<DustSiteInfo> queryMncodeBySiteName(String siteName) {
        Example example = new Example(DustSiteInfo.class);
        example.createCriteria().andEqualTo("name",siteName);
        List<DustSiteInfo> list  = dustSiteInfoMapper.selectByExample(example);
        return list;
    }



}
