package com.flightfeather.monitor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class DustExceptionSetting {
    private static int id;
    private static String user;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private static LocalDateTime updateTime;  //开始时间

    private static String version;

    private static int missDataMinutes;
    private static float dataLow;
    private static int longTimeNoChange;
    private static int mutationNum;
    private static float mutationRate;
    private static float nearExceedLowValue;
    private static float nearExceedHighValue;
    private static int nearExceedNum;
    private static int dayExceedBorderlineLowNum;
    private static int dayExceedBorderlineHighNum;
    private static int changeTrendGroup;
    private static int changeTrendInterval;
    private static int changeTrendRate;
    private static int exceedingStandard;

    private static DustExceptionSetting instance;


    public static DustExceptionSetting getInstance() {

        if (instance == null) {
            instance = new DustExceptionSetting();
        }
        return instance;
    }


}
