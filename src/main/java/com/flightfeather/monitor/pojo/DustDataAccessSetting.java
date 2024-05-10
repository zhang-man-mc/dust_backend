package com.flightfeather.monitor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DustDataAccessSetting {

    private int id;
    private String user;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private String type;
    private String exceeding;
    private String beginTime;
    private String endTime;
    private String region;
    private String isRegularTime;


}
