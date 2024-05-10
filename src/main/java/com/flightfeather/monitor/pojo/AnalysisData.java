package com.flightfeather.monitor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisData {
    //共22个属性
    private String fumeDevId;
    private String diName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fumeDate;

    private Double fumeDayMin;
    private Double fumeDayMax;
    private Double fumeDayAverage;

    private String  purifierOpenRate;

    private Integer fumeMinuteExceedingNum;
    private String fumeOverStandardRate;
    private String fumeDataEfficiency;
    private String dailyOnlineRate;

    private String noonOnlineRate;
    private String nightOnlineRate;
    private String keyOnlineRate;
    private String noonValidRate;
    private String nightValidRate;
    private String keyValidRate;

    private String noonOpeningCount;
    private String nightOpeningCount;
    private String keyOpeningRate;

    private String noonExceedingNum;
    private String nightExceedingNum;
    private String keyExceedingRate;

}
