package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "du_js_t_site_map")
public class DustSiteMap {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TZ_User_Id")
    private String tzUserId;

    @Column(name = "TZ_User_Name")
    private String tzUserName;

    @Column(name = "JS_Device_Code")
    private String jsDeviceCode;

    @Column(name = "JS_Device_Name")
    private String jsDeviceName;

    @Column(name = "SV_User_Id")
    private String svUserId;

    @Column(name = "SV_User_Name")
    private String svUserName;

    @Column(name = "Create_Time")
    private Date createTime;

    /**
     * @return Id
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
     * @return TZ_User_Id
     */
    public String getTzUserId() {
        return tzUserId;
    }

    /**
     * @param tzUserId
     */
    public void setTzUserId(String tzUserId) {
        this.tzUserId = tzUserId == null ? null : tzUserId.trim();
    }

    /**
     * @return TZ_User_Name
     */
    public String getTzUserName() {
        return tzUserName;
    }

    /**
     * @param tzUserName
     */
    public void setTzUserName(String tzUserName) {
        this.tzUserName = tzUserName == null ? null : tzUserName.trim();
    }

    /**
     * @return JS_Device_Code
     */
    public String getJsDeviceCode() {
        return jsDeviceCode;
    }

    /**
     * @param jsDeviceCode
     */
    public void setJsDeviceCode(String jsDeviceCode) {
        this.jsDeviceCode = jsDeviceCode == null ? null : jsDeviceCode.trim();
    }

    /**
     * @return JS_Device_Name
     */
    public String getJsDeviceName() {
        return jsDeviceName;
    }

    /**
     * @param jsDeviceName
     */
    public void setJsDeviceName(String jsDeviceName) {
        this.jsDeviceName = jsDeviceName == null ? null : jsDeviceName.trim();
    }

    /**
     * @return SV_User_Id
     */
    public String getSvUserId() {
        return svUserId;
    }

    /**
     * @param svUserId
     */
    public void setSvUserId(String svUserId) {
        this.svUserId = svUserId == null ? null : svUserId.trim();
    }

    /**
     * @return SV_User_Name
     */
    public String getSvUserName() {
        return svUserName;
    }

    /**
     * @param svUserName
     */
    public void setSvUserName(String svUserName) {
        this.svUserName = svUserName == null ? null : svUserName.trim();
    }

    /**
     * @return Create_Time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}