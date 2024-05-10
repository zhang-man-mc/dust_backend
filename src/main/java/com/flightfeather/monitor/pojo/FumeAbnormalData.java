package com.flightfeather.monitor.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//异常表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FumeAbnormalData {
    private String id;
    private String devId;    //设备编号
    private String diName;   //店铺名
    private String diSupplier;   //供应商
    private String exception;   //异常分类
    private String exceptionType;   //异常类型
    private String region;   //地区

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;  //开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;    //结束时间

}
