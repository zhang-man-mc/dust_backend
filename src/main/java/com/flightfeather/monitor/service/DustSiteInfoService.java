package com.flightfeather.monitor.service;

import com.flightfeather.monitor.domain.ds1.entity.DustSiteInfo;

import java.util.List;

/**
 * @ClassName: DustSiteInfoService
 * @Description: TODO
 * @author: yourname
 */

public interface DustSiteInfoService {
    List<DustSiteInfo> querySiteInfoBymnCode(String mnCode);

    List<DustSiteInfo> queryAllDutyCompany();

    List<DustSiteInfo> queryStreet(String street);

    List<DustSiteInfo> queryMncodeBySiteName(String siteName);
}
