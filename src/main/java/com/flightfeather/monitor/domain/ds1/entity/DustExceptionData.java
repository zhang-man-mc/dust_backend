package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "dust_exception_data")
public class DustExceptionData {
    @Id
    private Integer id;

    @Column(name = "mn_code")
    private String mnCode;

    private String exception;

    @Column(name = "exception_type")
    private Integer exceptionType;

    private String region;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "avg_value")
    private Double avgValue;

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
     * @return exception
     */
    public String getException() {
        return exception;
    }

    /**
     * @param exception
     */
    public void setException(String exception) {
        this.exception = exception == null ? null : exception.trim();
    }

    /**
     * @return exception_type
     */
    public Integer getExceptionType() {
        return exceptionType;
    }

    /**
     * @param exceptionType
     */
    public void setExceptionType(Integer exceptionType) {
        this.exceptionType = exceptionType;
    }

    /**
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * @return begin_time
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * @param beginTime
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return avg_value
     */
    public Double getAvgValue() {
        return avgValue;
    }

    /**
     * @param avgValue
     */
    public void setAvgValue(Double avgValue) {
        this.avgValue = avgValue;
    }
}