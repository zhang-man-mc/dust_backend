package com.flightfeather.monitor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.ws.soap.Addressing;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DustExceptionData {
    /*异常表*/
    private String id;
    private String name;   //站点名字
    private String mnCode;      //设备编号
    private String typename;   //场景
    private String address;     //地址

    private String dutyCompany;    //运维商

    private String exception;

    private String exceptionType;

    private String region;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;


    /*审核结果表*/
    private String auditId;
    private  String exceptionId;
    private  String checker;
    private  String checkerContent;
    private  String enterpriseContent;
    private  int auditStatus;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}
