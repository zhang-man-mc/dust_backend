package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "du_js_t_request_task_log")
public class RequestTaskLog {
    @Id
    private Integer id;

    @Column(name = "request_id")
    private Integer requestId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "log_type")
    private String logType;

    private String log;

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
     * @return request_id
     */
    public Integer getRequestId() {
        return requestId;
    }

    /**
     * @param requestId
     */
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return log_type
     */
    public String getLogType() {
        return logType;
    }

    /**
     * @param logType
     */
    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    /**
     * @return log
     */
    public String getLog() {
        return log;
    }

    /**
     * @param log
     */
    public void setLog(String log) {
        this.log = log == null ? null : log.trim();
    }
}