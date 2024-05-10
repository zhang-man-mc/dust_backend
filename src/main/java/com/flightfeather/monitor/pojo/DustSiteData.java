package com.flightfeather.monitor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 监测点
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DustSiteData {
    private String name;
    private String address;
    private String sName;
    //    供应商
    private String dutyCompany;
    private String groupName;



    private String mnCode;
    private String typeName;
    private double dustValue;
    private double noiseValue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lst;
    private String quality;
    private String Grade;
    private String flag;

}
