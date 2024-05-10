package com.flightfeather.monitor.domain.ds1.entity;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "du_js_t_request_task_setting")
public class RequestTaskSetting {
    @Id
    private Integer id;

    private String user;

    @Column(name = "update_time")
    private Date updateTime;

    private String region;

    private String version;

    /**
     * 数据爬取开始时间
     */
    @Column(name = "request_start_time")
    private Date requestStartTime;

    /**
     * 数据爬取结束时间
     */
    @Column(name = "request_end_time")
    private Date requestEndTime;

    /**
     * 在爬取任务开始结束时间内，爬取的频率
     */
    @Column(name = "request_interval_seconds")
    private Integer requestIntervalSeconds;

    /**
     * 一次数据爬取任务中，按总时长分段执行的每段时间长度
     */
    @Column(name = "request_range_hour")
    private Integer requestRangeHour;

    /**
     * 一次数据爬取任务中，分段执行时的每段的间隔时间
     */
    @Column(name = "request_range_interval_seconds")
    private Integer requestRangeIntervalSeconds;

    /**
     * 爬取任务异常时再次尝试间隔
     */
    @Column(name = "request_fail_wait_seconds")
    private Integer requestFailWaitSeconds;

    /**
     * 爬取失败时再次尝试的总次数
     */
    @Column(name = "request_retry_times")
    private Integer requestRetryTimes;

    @Column(name = "statics_daily_time")
    private Date staticsDailyTime;

    @Column(name = "statics_monthly_time")
    private Date staticsMonthlyTime;

    /**
     * 单次登陆失败重新尝试等待时间
     */
    @Column(name = "login_fail_wait_seconds")
    private Integer loginFailWaitSeconds;

    /**
     * 登陆失败连续尝试次数
     */
    @Column(name = "login_retry_times")
    private Integer loginRetryTimes;

    /**
     * 整个爬取任务重新开始尝试等待时间
     */
    @Column(name = "task_retry_wait_seconds")
    private Integer taskRetryWaitSeconds;

    /**
     * 程序首次执行, 站点数据最新时刻表为空时, 数据获取开始时间相对当日往前偏移的天数
     */
    @Column(name = "first_request_offset_days")
    private Integer firstRequestOffsetDays;

    /**
     * cookie有效时长，单位小时
     */
    @Column(name = "request_cookie_valid_duration")
    private Integer requestCookieValidDuration;

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
     * 获取数据爬取开始时间
     *
     * @return request_start_time - 数据爬取开始时间
     */
    public Date getRequestStartTime() {
        return requestStartTime;
    }

    /**
     * 设置数据爬取开始时间
     *
     * @param requestStartTime 数据爬取开始时间
     */
    public void setRequestStartTime(Date requestStartTime) {
        this.requestStartTime = requestStartTime;
    }

    /**
     * 获取数据爬取结束时间
     *
     * @return request_end_time - 数据爬取结束时间
     */
    public Date getRequestEndTime() {
        return requestEndTime;
    }

    /**
     * 设置数据爬取结束时间
     *
     * @param requestEndTime 数据爬取结束时间
     */
    public void setRequestEndTime(Date requestEndTime) {
        this.requestEndTime = requestEndTime;
    }

    /**
     * 获取在爬取任务开始结束时间内，爬取的频率
     *
     * @return request_interval_seconds - 在爬取任务开始结束时间内，爬取的频率
     */
    public Integer getRequestIntervalSeconds() {
        return requestIntervalSeconds;
    }

    /**
     * 设置在爬取任务开始结束时间内，爬取的频率
     *
     * @param requestIntervalSeconds 在爬取任务开始结束时间内，爬取的频率
     */
    public void setRequestIntervalSeconds(Integer requestIntervalSeconds) {
        this.requestIntervalSeconds = requestIntervalSeconds;
    }

    /**
     * 获取一次数据爬取任务中，按总时长分段执行的每段时间长度
     *
     * @return request_range_hour - 一次数据爬取任务中，按总时长分段执行的每段时间长度
     */
    public Integer getRequestRangeHour() {
        return requestRangeHour;
    }

    /**
     * 设置一次数据爬取任务中，按总时长分段执行的每段时间长度
     *
     * @param requestRangeHour 一次数据爬取任务中，按总时长分段执行的每段时间长度
     */
    public void setRequestRangeHour(Integer requestRangeHour) {
        this.requestRangeHour = requestRangeHour;
    }

    /**
     * 获取一次数据爬取任务中，分段执行时的每段的间隔时间
     *
     * @return request_range_interval_seconds - 一次数据爬取任务中，分段执行时的每段的间隔时间
     */
    public Integer getRequestRangeIntervalSeconds() {
        return requestRangeIntervalSeconds;
    }

    /**
     * 设置一次数据爬取任务中，分段执行时的每段的间隔时间
     *
     * @param requestRangeIntervalSeconds 一次数据爬取任务中，分段执行时的每段的间隔时间
     */
    public void setRequestRangeIntervalSeconds(Integer requestRangeIntervalSeconds) {
        this.requestRangeIntervalSeconds = requestRangeIntervalSeconds;
    }

    /**
     * 获取爬取任务异常时再次尝试间隔
     *
     * @return request_fail_wait_seconds - 爬取任务异常时再次尝试间隔
     */
    public Integer getRequestFailWaitSeconds() {
        return requestFailWaitSeconds;
    }

    /**
     * 设置爬取任务异常时再次尝试间隔
     *
     * @param requestFailWaitSeconds 爬取任务异常时再次尝试间隔
     */
    public void setRequestFailWaitSeconds(Integer requestFailWaitSeconds) {
        this.requestFailWaitSeconds = requestFailWaitSeconds;
    }

    /**
     * 获取爬取失败时再次尝试的总次数
     *
     * @return request_retry_times - 爬取失败时再次尝试的总次数
     */
    public Integer getRequestRetryTimes() {
        return requestRetryTimes;
    }

    /**
     * 设置爬取失败时再次尝试的总次数
     *
     * @param requestRetryTimes 爬取失败时再次尝试的总次数
     */
    public void setRequestRetryTimes(Integer requestRetryTimes) {
        this.requestRetryTimes = requestRetryTimes;
    }

    /**
     * @return statics_daily_time
     */
    public Date getStaticsDailyTime() {
        return staticsDailyTime;
    }

    /**
     * @param staticsDailyTime
     */
    public void setStaticsDailyTime(Date staticsDailyTime) {
        this.staticsDailyTime = staticsDailyTime;
    }

    /**
     * @return statics_monthly_time
     */
    public Date getStaticsMonthlyTime() {
        return staticsMonthlyTime;
    }

    /**
     * @param staticsMonthlyTime
     */
    public void setStaticsMonthlyTime(Date staticsMonthlyTime) {
        this.staticsMonthlyTime = staticsMonthlyTime;
    }

    /**
     * 获取单次登陆失败重新尝试等待时间
     *
     * @return login_fail_wait_seconds - 单次登陆失败重新尝试等待时间
     */
    public Integer getLoginFailWaitSeconds() {
        return loginFailWaitSeconds;
    }

    /**
     * 设置单次登陆失败重新尝试等待时间
     *
     * @param loginFailWaitSeconds 单次登陆失败重新尝试等待时间
     */
    public void setLoginFailWaitSeconds(Integer loginFailWaitSeconds) {
        this.loginFailWaitSeconds = loginFailWaitSeconds;
    }

    /**
     * 获取登陆失败连续尝试次数
     *
     * @return login_retry_times - 登陆失败连续尝试次数
     */
    public Integer getLoginRetryTimes() {
        return loginRetryTimes;
    }

    /**
     * 设置登陆失败连续尝试次数
     *
     * @param loginRetryTimes 登陆失败连续尝试次数
     */
    public void setLoginRetryTimes(Integer loginRetryTimes) {
        this.loginRetryTimes = loginRetryTimes;
    }

    /**
     * 获取整个爬取任务重新开始尝试等待时间
     *
     * @return task_retry_wait_seconds - 整个爬取任务重新开始尝试等待时间
     */
    public Integer getTaskRetryWaitSeconds() {
        return taskRetryWaitSeconds;
    }

    /**
     * 设置整个爬取任务重新开始尝试等待时间
     *
     * @param taskRetryWaitSeconds 整个爬取任务重新开始尝试等待时间
     */
    public void setTaskRetryWaitSeconds(Integer taskRetryWaitSeconds) {
        this.taskRetryWaitSeconds = taskRetryWaitSeconds;
    }

    /**
     * 获取程序首次执行, 站点数据最新时刻表为空时, 数据获取开始时间相对当日往前偏移的天数
     *
     * @return first_request_offset_days - 程序首次执行, 站点数据最新时刻表为空时, 数据获取开始时间相对当日往前偏移的天数
     */
    public Integer getFirstRequestOffsetDays() {
        return firstRequestOffsetDays;
    }

    /**
     * 设置程序首次执行, 站点数据最新时刻表为空时, 数据获取开始时间相对当日往前偏移的天数
     *
     * @param firstRequestOffsetDays 程序首次执行, 站点数据最新时刻表为空时, 数据获取开始时间相对当日往前偏移的天数
     */
    public void setFirstRequestOffsetDays(Integer firstRequestOffsetDays) {
        this.firstRequestOffsetDays = firstRequestOffsetDays;
    }

    /**
     * 获取cookie有效时长，单位小时
     *
     * @return request_cookie_valid_duration - cookie有效时长，单位小时
     */
    public Integer getRequestCookieValidDuration() {
        return requestCookieValidDuration;
    }

    /**
     * 设置cookie有效时长，单位小时
     *
     * @param requestCookieValidDuration cookie有效时长，单位小时
     */
    public void setRequestCookieValidDuration(Integer requestCookieValidDuration) {
        this.requestCookieValidDuration = requestCookieValidDuration;
    }
}