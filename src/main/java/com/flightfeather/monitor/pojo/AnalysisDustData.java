package com.flightfeather.monitor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisDustData {

    private String mnCode;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lst;

    private Double dayAvg;
    private Double min;
    private Double max;
    private Double dayOnline;
    private Double dayValid;
    private Double  dayExceeding;
    private String  type;
}
