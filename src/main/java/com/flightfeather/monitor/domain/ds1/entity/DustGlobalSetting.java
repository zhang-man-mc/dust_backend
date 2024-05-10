package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "dust_global_setting")
public class DustGlobalSetting {
    @Id
    private Integer id;

    /**
     * 用户
     */
    private String user;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 类型（扬尘，油烟）
     */
    private String type;

    /**
     * 超标预设值
     */
    private Double exceeding;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;

    private String region;

    @Column(name = "is_regular_time")
    private String isRegularTime;

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
     * 获取用户
     *
     * @return user - 用户
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置用户
     *
     * @param user 用户
     */
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取类型（扬尘，油烟）
     *
     * @return type - 类型（扬尘，油烟）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型（扬尘，油烟）
     *
     * @param type 类型（扬尘，油烟）
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取超标预设值
     *
     * @return exceeding - 超标预设值
     */
    public Double getExceeding() {
        return exceeding;
    }

    /**
     * 设置超标预设值
     *
     * @param exceeding 超标预设值
     */
    public void setExceeding(Double exceeding) {
        this.exceeding = exceeding;
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
     * @return is_regular_time
     */
    public String getIsRegularTime() {
        return isRegularTime;
    }

    /**
     * @param isRegularTime
     */
    public void setIsRegularTime(String isRegularTime) {
        this.isRegularTime = isRegularTime == null ? null : isRegularTime.trim();
    }
}