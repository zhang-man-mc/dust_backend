package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "du_js_t_request_task")
public class RequestTask {
    @Id
    private Integer id;

    /**
     * 任务开启时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 任务结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 运行状态
     */
    @Column(name = "running_status")
    private Boolean runningStatus;

    /**
     * 任务是否成功完成
     */
    private Boolean success;

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
     * 获取任务开启时间
     *
     * @return start_time - 任务开启时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置任务开启时间
     *
     * @param startTime 任务开启时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取任务结束时间
     *
     * @return end_time - 任务结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置任务结束时间
     *
     * @param endTime 任务结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取运行状态
     *
     * @return running_status - 运行状态
     */
    public Boolean getRunningStatus() {
        return runningStatus;
    }

    /**
     * 设置运行状态
     *
     * @param runningStatus 运行状态
     */
    public void setRunningStatus(Boolean runningStatus) {
        this.runningStatus = runningStatus;
    }

    /**
     * 获取任务是否成功完成
     *
     * @return success - 任务是否成功完成
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 设置任务是否成功完成
     *
     * @param success 任务是否成功完成
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}