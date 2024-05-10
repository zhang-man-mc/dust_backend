package com.flightfeather.monitor.controller.dust;

import com.flightfeather.monitor.domain.ds1.entity.DustSiteInfo;
import com.flightfeather.monitor.pojo.Result;
import com.flightfeather.monitor.pojo.RiskValuePojo;
import com.flightfeather.monitor.service.DustSiteInfoService;
import com.flightfeather.monitor.service.RiskValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: DustSiteInfo
 * @Description: TODO
 * @author: yourname
 */


@Slf4j
@RestController
@RequestMapping("/dust/siteInfo")
@CrossOrigin
public class DustSiteInfoController {
    @Autowired
    private DustSiteInfoService dustSiteInfoService;


    /**
     * 根据设备编码查询站点基本信息
     *
     * @param mnCode
     * @return
     */
    @GetMapping("/info")
    public Result querySiteInfoBymnCode(String mnCode) {


        List<DustSiteInfo> list = dustSiteInfoService.querySiteInfoBymnCode(mnCode);
        return Result.success(list);
    }

    @GetMapping("/dutyCompany")
    public Result queryAllDutyCompany() {


        List<DustSiteInfo> list = dustSiteInfoService.queryAllDutyCompany();
        return Result.success(list);
    }

    @GetMapping("/street")
    public Result queryStreet(String street) {


        List<DustSiteInfo> list = dustSiteInfoService.queryStreet(street);
        return Result.success(list);
    }

    /*根据点位名字查询对应的设备编号*/
    @GetMapping("/mncode")
    public Result queryMncodeBySiteName(String siteName) {

        List<DustSiteInfo> list = dustSiteInfoService.queryMncodeBySiteName(siteName);
        return Result.success(list);
    }

}
