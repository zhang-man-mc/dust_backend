package com.flightfeather.monitor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FumeHistoryData {

    private String mvStatCode;          //设备编号
    private String diName;              //店铺名称
    private String diSupplier;          //供应商

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime mvCreateTime;        //上报时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime mvDataTime;         //归属时间

    private String mvFanElectricity;          //风机电
    private String mvPurifierElectricity;    //净化器电流

    private String mvFumeConcentration2;   //排烟浓度


}
