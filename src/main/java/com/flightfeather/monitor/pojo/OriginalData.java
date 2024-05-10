package com.flightfeather.monitor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OriginalData {
    private Integer id;
    private String provider;
    private String shopName;
    private String equipmentNumber;
    private String equipmentName;
    private String smokePushDensity;
    private String smokePopDensity;
    private String windTurbine;
    private String purifier;
    private String level;
    private String alarmRequired;
    private String alarmTriggered;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //只是在将实体返回JSON格式数据时才有效的转换为(yyyy-MM-dd HH:mm:ss)格式的时间，其他时候日期格式不会被转换
    private LocalDateTime attributionTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reportingTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String dateTime;
}
