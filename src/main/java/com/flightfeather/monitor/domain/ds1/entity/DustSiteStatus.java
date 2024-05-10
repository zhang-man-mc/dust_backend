package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "du_js_t_site_latest_time")
public class DustSiteStatus {
    @Id
    @Column(name = "mn_code")
    private String mnCode;

    @Column(name = "latest_time")
    private Date latestTime;

    @Column(name = "device_status")
    private Integer deviceStatus;

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
     * @return latest_time
     */
    public Date getLatestTime() {
        return latestTime;
    }

    /**
     * @param latestTime
     */
    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }

    /**
     * @return device_status
     */
    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    /**
     * @param deviceStatus
     */
    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }
}