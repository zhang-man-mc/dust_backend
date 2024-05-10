package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "dust_exception_setting")
public class DustExceptionSetting {
    @Id
    private Integer id;

    private String user;

    @Column(name = "update_time")
    private Date updateTime;

    private String region;

    private String version;

    @Column(name = "miss_data_minutes")
    private Integer missDataMinutes;

    @Column(name = "data_low")
    private Double dataLow;

    @Column(name = "long_time_no_change")
    private Integer longTimeNoChange;

    @Column(name = "mutation_num")
    private Integer mutationNum;

    @Column(name = "mutation_rate")
    private Double mutationRate;

    @Column(name = "near_exceed_low_value")
    private Double nearExceedLowValue;

    @Column(name = "near_exceed_high_value")
    private Double nearExceedHighValue;

    @Column(name = "near_exceed_num")
    private Integer nearExceedNum;

    @Column(name = "day_exceed_borderline_low_num")
    private Integer dayExceedBorderlineLowNum;

    @Column(name = "day_exceed_borderline_high_num")
    private Integer dayExceedBorderlineHighNum;

    @Column(name = "change_trend_group")
    private Integer changeTrendGroup;

    @Column(name = "change_trend_interval")
    private Integer changeTrendInterval;

    @Column(name = "change_trend_rate")
    private Double changeTrendRate;

    /**
     * 滑动平均值变化率异常连续次数
     */
    @Column(name = "change_trend_times")
    private Integer changeTrendTimes;

    @Column(name = "exceeding_standard")
    private Double exceedingStandard;

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
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user
     */
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * @return miss_data_minutes
     */
    public Integer getMissDataMinutes() {
        return missDataMinutes;
    }

    /**
     * @param missDataMinutes
     */
    public void setMissDataMinutes(Integer missDataMinutes) {
        this.missDataMinutes = missDataMinutes;
    }

    /**
     * @return data_low
     */
    public Double getDataLow() {
        return dataLow;
    }

    /**
     * @param dataLow
     */
    public void setDataLow(Double dataLow) {
        this.dataLow = dataLow;
    }

    /**
     * @return long_time_no_change
     */
    public Integer getLongTimeNoChange() {
        return longTimeNoChange;
    }

    /**
     * @param longTimeNoChange
     */
    public void setLongTimeNoChange(Integer longTimeNoChange) {
        this.longTimeNoChange = longTimeNoChange;
    }

    /**
     * @return mutation_num
     */
    public Integer getMutationNum() {
        return mutationNum;
    }

    /**
     * @param mutationNum
     */
    public void setMutationNum(Integer mutationNum) {
        this.mutationNum = mutationNum;
    }

    /**
     * @return mutation_rate
     */
    public Double getMutationRate() {
        return mutationRate;
    }

    /**
     * @param mutationRate
     */
    public void setMutationRate(Double mutationRate) {
        this.mutationRate = mutationRate;
    }

    /**
     * @return near_exceed_low_value
     */
    public Double getNearExceedLowValue() {
        return nearExceedLowValue;
    }

    /**
     * @param nearExceedLowValue
     */
    public void setNearExceedLowValue(Double nearExceedLowValue) {
        this.nearExceedLowValue = nearExceedLowValue;
    }

    /**
     * @return near_exceed_high_value
     */
    public Double getNearExceedHighValue() {
        return nearExceedHighValue;
    }

    /**
     * @param nearExceedHighValue
     */
    public void setNearExceedHighValue(Double nearExceedHighValue) {
        this.nearExceedHighValue = nearExceedHighValue;
    }

    /**
     * @return near_exceed_num
     */
    public Integer getNearExceedNum() {
        return nearExceedNum;
    }

    /**
     * @param nearExceedNum
     */
    public void setNearExceedNum(Integer nearExceedNum) {
        this.nearExceedNum = nearExceedNum;
    }

    /**
     * @return day_exceed_borderline_low_num
     */
    public Integer getDayExceedBorderlineLowNum() {
        return dayExceedBorderlineLowNum;
    }

    /**
     * @param dayExceedBorderlineLowNum
     */
    public void setDayExceedBorderlineLowNum(Integer dayExceedBorderlineLowNum) {
        this.dayExceedBorderlineLowNum = dayExceedBorderlineLowNum;
    }

    /**
     * @return day_exceed_borderline_high_num
     */
    public Integer getDayExceedBorderlineHighNum() {
        return dayExceedBorderlineHighNum;
    }

    /**
     * @param dayExceedBorderlineHighNum
     */
    public void setDayExceedBorderlineHighNum(Integer dayExceedBorderlineHighNum) {
        this.dayExceedBorderlineHighNum = dayExceedBorderlineHighNum;
    }

    /**
     * @return change_trend_group
     */
    public Integer getChangeTrendGroup() {
        return changeTrendGroup;
    }

    /**
     * @param changeTrendGroup
     */
    public void setChangeTrendGroup(Integer changeTrendGroup) {
        this.changeTrendGroup = changeTrendGroup;
    }

    /**
     * @return change_trend_interval
     */
    public Integer getChangeTrendInterval() {
        return changeTrendInterval;
    }

    /**
     * @param changeTrendInterval
     */
    public void setChangeTrendInterval(Integer changeTrendInterval) {
        this.changeTrendInterval = changeTrendInterval;
    }

    /**
     * @return change_trend_rate
     */
    public Double getChangeTrendRate() {
        return changeTrendRate;
    }

    /**
     * @param changeTrendRate
     */
    public void setChangeTrendRate(Double changeTrendRate) {
        this.changeTrendRate = changeTrendRate;
    }

    /**
     * 获取滑动平均值变化率异常连续次数
     *
     * @return change_trend_times - 滑动平均值变化率异常连续次数
     */
    public Integer getChangeTrendTimes() {
        return changeTrendTimes;
    }

    /**
     * 设置滑动平均值变化率异常连续次数
     *
     * @param changeTrendTimes 滑动平均值变化率异常连续次数
     */
    public void setChangeTrendTimes(Integer changeTrendTimes) {
        this.changeTrendTimes = changeTrendTimes;
    }

    /**
     * @return exceeding_standard
     */
    public Double getExceedingStandard() {
        return exceedingStandard;
    }

    /**
     * @param exceedingStandard
     */
    public void setExceedingStandard(Double exceedingStandard) {
        this.exceedingStandard = exceedingStandard;
    }
}