package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "dust_statistics_value")
public class DustStatisticsValue {
    @Id
    private Integer id;

    @Column(name = "mn_code")
    private String mnCode;

    private Date lst;

    @Column(name = "day_avg")
    private Double dayAvg;

    private Double min;

    private Double max;

    @Column(name = "day_online")
    private Double dayOnline;

    @Column(name = "day_valid")
    private Double dayValid;

    @Column(name = "day_exceeding")
    private Double dayExceeding;

    private String type;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return mn_code
     */
    public String getMnCode() {
        return mnCode;
    }

    /**
     * @param mnCode
     */
    public void setMnCode(String mnCode) {
        this.mnCode = mnCode == null ? null : mnCode.trim();
    }

    /**
     * @return lst
     */
    public Date getLst() {
        return lst;
    }

    /**
     * @param lst
     */
    public void setLst(Date lst) {
        this.lst = lst;
    }

    /**
     * @return day_avg
     */
    public Double getDayAvg() {
        return dayAvg;
    }

    /**
     * @param dayAvg
     */
    public void setDayAvg(Double dayAvg) {
        this.dayAvg = dayAvg;
    }

    /**
     * @return min
     */
    public Double getMin() {
        return min;
    }

    /**
     * @param min
     */
    public void setMin(Double min) {
        this.min = min;
    }

    /**
     * @return max
     */
    public Double getMax() {
        return max;
    }

    /**
     * @param max
     */
    public void setMax(Double max) {
        this.max = max;
    }

    /**
     * @return day_online
     */
    public Double getDayOnline() {
        return dayOnline;
    }

    /**
     * @param dayOnline
     */
    public void setDayOnline(Double dayOnline) {
        this.dayOnline = dayOnline;
    }

    /**
     * @return day_valid
     */
    public Double getDayValid() {
        return dayValid;
    }

    /**
     * @param dayValid
     */
    public void setDayValid(Double dayValid) {
        this.dayValid = dayValid;
    }

    /**
     * @return day_exceeding
     */
    public Double getDayExceeding() {
        return dayExceeding;
    }

    /**
     * @param dayExceeding
     */
    public void setDayExceeding(Double dayExceeding) {
        this.dayExceeding = dayExceeding;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}