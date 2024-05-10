package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ja_t_dust_site_info")
public class DustSiteInfo {
    @Id
    private Integer id;

    /**
     * 设备编码
     */
    @Column(name = "mn_code")
    private String mnCode;

    /**
     * 安装地址
     */
    private String address;

    /**
     * 站点名称
     */
    private String name;

    /**
     * 站点编码
     */
    private String code;

    /**
     * 开工时间
     */
    @Column(name = "begin_date")
    private Date beginDate;

    /**
     * 运维商
     */
    @Column(name = "duty_company")
    private String dutyCompany;

    /**
     * 运维商id
     */
    @Column(name = "duty_company_id")
    private String dutyCompanyId;

    /**
     * 结束时间
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 当前施工阶段
     */
    @Column(name = "engineering_stage")
    private String engineeringStage;

    /**
     * 所属区县代码
     */
    @Column(name = "group_id")
    private String groupId;

    /**
     * 所属区县
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 是否在线
     */
    @Column(name = "is_online")
    private String isOnline;

    /**
     * 设备是否异常
     */
    @Column(name = "is_trouble")
    private String isTrouble;

    /**
     * 更新时间
     */
    @Column(name = "jhpt_update_time")
    private String jhptUpdateTime;

    private String kindex;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 联系人电话
     */
    private String phone;

    /**
     * 所属省份
     */
    private String province;

    /**
     * 内中外环编码
     */
    @Column(name = "ring_id")
    private String ringId;

    /**
     * 内中外环
     */
    @Column(name = "ring_name")
    private String ringName;

    /**
     * 类型编码
     */
    @Column(name = "type_id")
    private String typeId;

    /**
     * 类型名称
     */
    private String typename;

    /**
     * 停止时间
     */
    @Column(name = "stop_time")
    private Date stopTime;

    private String active;

    /**
     * 故障次数
     */
    @Column(name = "trouble_num")
    private Integer troubleNum;

    /**
     * 新增时间
     */
    @Column(name = "insert_time")
    private Date insertTime;

    /**
     * 阶段开始日期
     */
    @Column(name = "stage_begin_date")
    private Date stageBeginDate;

    /**
     * tsp浓度
     */
    private Double tsp;

    /**
     * 统计类型编码
     */
    @Column(name = "union_type_id")
    private String unionTypeId;

    /**
     * 围墙高度
     */
    @Column(name = "wall_height")
    private String wallHeight;

    /**
     * 业务时间
     */
    @Column(name = "ywsj_date")
    private Date ywsjDate;

    /**
     * 建筑面积
     */
    @Column(name = "build_area")
    private String buildArea;

    /**
     * 施工单位
     */
    @Column(name = "construction_unit")
    private String constructionUnit;

    /**
     * 点位控制级
     */
    @Column(name = "control_level")
    private String controlLevel;

    /**
     * 开发商
     */
    private String developers;

    /**
     * 执行时间
     */
    @Column(name = "do_time")
    private Date doTime;

    /**
     * 是否有监测
     */
    @Column(name = "has_monitor")
    private String hasMonitor;

    /**
     * 采集时间
     */
    @Column(name = "data_time")
    private Date dataTime;

    /**
     * 当前施工阶段编码
     */
    @Column(name = "engineering_stage_code")
    private String engineeringStageCode;

    /**
     * 设备编码
     */
    @Column(name = "equipment_code")
    private String equipmentCode;

    /**
     * 占地面积
     */
    @Column(name = "floor_area")
    private String floorArea;

    /**
     * 删除标志位
     */
    @Column(name = "jhpt_delete")
    private String jhptDelete;

    /**
     * 噪声功能区
     */
    @Column(name = "noise_region")
    private String noiseRegion;

    /**
     * 负责人
     */
    private String responsible;

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
     * 获取设备编码
     *
     * @return mn_code - 设备编码
     */
    public String getMnCode() {
        return mnCode;
    }

    /**
     * 设置设备编码
     *
     * @param mnCode 设备编码
     */
    public void setMnCode(String mnCode) {
        this.mnCode = mnCode == null ? null : mnCode.trim();
    }

    /**
     * 获取安装地址
     *
     * @return address - 安装地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置安装地址
     *
     * @param address 安装地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取站点名称
     *
     * @return name - 站点名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置站点名称
     *
     * @param name 站点名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取站点编码
     *
     * @return code - 站点编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置站点编码
     *
     * @param code 站点编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取开工时间
     *
     * @return begin_date - 开工时间
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 设置开工时间
     *
     * @param beginDate 开工时间
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取运维商
     *
     * @return duty_company - 运维商
     */
    public String getDutyCompany() {
        return dutyCompany;
    }

    /**
     * 设置运维商
     *
     * @param dutyCompany 运维商
     */
    public void setDutyCompany(String dutyCompany) {
        this.dutyCompany = dutyCompany == null ? null : dutyCompany.trim();
    }

    /**
     * 获取运维商id
     *
     * @return duty_company_id - 运维商id
     */
    public String getDutyCompanyId() {
        return dutyCompanyId;
    }

    /**
     * 设置运维商id
     *
     * @param dutyCompanyId 运维商id
     */
    public void setDutyCompanyId(String dutyCompanyId) {
        this.dutyCompanyId = dutyCompanyId == null ? null : dutyCompanyId.trim();
    }

    /**
     * 获取结束时间
     *
     * @return end_date - 结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置结束时间
     *
     * @param endDate 结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取当前施工阶段
     *
     * @return engineering_stage - 当前施工阶段
     */
    public String getEngineeringStage() {
        return engineeringStage;
    }

    /**
     * 设置当前施工阶段
     *
     * @param engineeringStage 当前施工阶段
     */
    public void setEngineeringStage(String engineeringStage) {
        this.engineeringStage = engineeringStage == null ? null : engineeringStage.trim();
    }

    /**
     * 获取所属区县代码
     *
     * @return group_id - 所属区县代码
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置所属区县代码
     *
     * @param groupId 所属区县代码
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * 获取所属区县
     *
     * @return group_name - 所属区县
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置所属区县
     *
     * @param groupName 所属区县
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 获取是否在线
     *
     * @return is_online - 是否在线
     */
    public String getIsOnline() {
        return isOnline;
    }

    /**
     * 设置是否在线
     *
     * @param isOnline 是否在线
     */
    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline == null ? null : isOnline.trim();
    }

    /**
     * 获取设备是否异常
     *
     * @return is_trouble - 设备是否异常
     */
    public String getIsTrouble() {
        return isTrouble;
    }

    /**
     * 设置设备是否异常
     *
     * @param isTrouble 设备是否异常
     */
    public void setIsTrouble(String isTrouble) {
        this.isTrouble = isTrouble == null ? null : isTrouble.trim();
    }

    /**
     * 获取更新时间
     *
     * @return jhpt_update_time - 更新时间
     */
    public String getJhptUpdateTime() {
        return jhptUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param jhptUpdateTime 更新时间
     */
    public void setJhptUpdateTime(String jhptUpdateTime) {
        this.jhptUpdateTime = jhptUpdateTime == null ? null : jhptUpdateTime.trim();
    }

    /**
     * @return kindex
     */
    public String getKindex() {
        return kindex;
    }

    /**
     * @param kindex
     */
    public void setKindex(String kindex) {
        this.kindex = kindex == null ? null : kindex.trim();
    }

    /**
     * 获取纬度
     *
     * @return latitude - 纬度
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置纬度
     *
     * @param latitude 纬度
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * 获取联系人
     *
     * @return linkman - 联系人
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * 设置联系人
     *
     * @param linkman 联系人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 获取联系人电话
     *
     * @return phone - 联系人电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系人电话
     *
     * @param phone 联系人电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取所属省份
     *
     * @return province - 所属省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置所属省份
     *
     * @param province 所属省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取内中外环编码
     *
     * @return ring_id - 内中外环编码
     */
    public String getRingId() {
        return ringId;
    }

    /**
     * 设置内中外环编码
     *
     * @param ringId 内中外环编码
     */
    public void setRingId(String ringId) {
        this.ringId = ringId == null ? null : ringId.trim();
    }

    /**
     * 获取内中外环
     *
     * @return ring_name - 内中外环
     */
    public String getRingName() {
        return ringName;
    }

    /**
     * 设置内中外环
     *
     * @param ringName 内中外环
     */
    public void setRingName(String ringName) {
        this.ringName = ringName == null ? null : ringName.trim();
    }

    /**
     * 获取类型编码
     *
     * @return type_id - 类型编码
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 设置类型编码
     *
     * @param typeId 类型编码
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    /**
     * 获取类型名称
     *
     * @return typename - 类型名称
     */
    public String getTypename() {
        return typename;
    }

    /**
     * 设置类型名称
     *
     * @param typename 类型名称
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    /**
     * 获取停止时间
     *
     * @return stop_time - 停止时间
     */
    public Date getStopTime() {
        return stopTime;
    }

    /**
     * 设置停止时间
     *
     * @param stopTime 停止时间
     */
    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * @return active
     */
    public String getActive() {
        return active;
    }

    /**
     * @param active
     */
    public void setActive(String active) {
        this.active = active == null ? null : active.trim();
    }

    /**
     * 获取故障次数
     *
     * @return trouble_num - 故障次数
     */
    public Integer getTroubleNum() {
        return troubleNum;
    }

    /**
     * 设置故障次数
     *
     * @param troubleNum 故障次数
     */
    public void setTroubleNum(Integer troubleNum) {
        this.troubleNum = troubleNum;
    }

    /**
     * 获取新增时间
     *
     * @return insert_time - 新增时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * 设置新增时间
     *
     * @param insertTime 新增时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * 获取阶段开始日期
     *
     * @return stage_begin_date - 阶段开始日期
     */
    public Date getStageBeginDate() {
        return stageBeginDate;
    }

    /**
     * 设置阶段开始日期
     *
     * @param stageBeginDate 阶段开始日期
     */
    public void setStageBeginDate(Date stageBeginDate) {
        this.stageBeginDate = stageBeginDate;
    }

    /**
     * 获取tsp浓度
     *
     * @return tsp - tsp浓度
     */
    public Double getTsp() {
        return tsp;
    }

    /**
     * 设置tsp浓度
     *
     * @param tsp tsp浓度
     */
    public void setTsp(Double tsp) {
        this.tsp = tsp;
    }

    /**
     * 获取统计类型编码
     *
     * @return union_type_id - 统计类型编码
     */
    public String getUnionTypeId() {
        return unionTypeId;
    }

    /**
     * 设置统计类型编码
     *
     * @param unionTypeId 统计类型编码
     */
    public void setUnionTypeId(String unionTypeId) {
        this.unionTypeId = unionTypeId == null ? null : unionTypeId.trim();
    }

    /**
     * 获取围墙高度
     *
     * @return wall_height - 围墙高度
     */
    public String getWallHeight() {
        return wallHeight;
    }

    /**
     * 设置围墙高度
     *
     * @param wallHeight 围墙高度
     */
    public void setWallHeight(String wallHeight) {
        this.wallHeight = wallHeight == null ? null : wallHeight.trim();
    }

    /**
     * 获取业务时间
     *
     * @return ywsj_date - 业务时间
     */
    public Date getYwsjDate() {
        return ywsjDate;
    }

    /**
     * 设置业务时间
     *
     * @param ywsjDate 业务时间
     */
    public void setYwsjDate(Date ywsjDate) {
        this.ywsjDate = ywsjDate;
    }

    /**
     * 获取建筑面积
     *
     * @return build_area - 建筑面积
     */
    public String getBuildArea() {
        return buildArea;
    }

    /**
     * 设置建筑面积
     *
     * @param buildArea 建筑面积
     */
    public void setBuildArea(String buildArea) {
        this.buildArea = buildArea == null ? null : buildArea.trim();
    }

    /**
     * 获取施工单位
     *
     * @return construction_unit - 施工单位
     */
    public String getConstructionUnit() {
        return constructionUnit;
    }

    /**
     * 设置施工单位
     *
     * @param constructionUnit 施工单位
     */
    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit == null ? null : constructionUnit.trim();
    }

    /**
     * 获取点位控制级
     *
     * @return control_level - 点位控制级
     */
    public String getControlLevel() {
        return controlLevel;
    }

    /**
     * 设置点位控制级
     *
     * @param controlLevel 点位控制级
     */
    public void setControlLevel(String controlLevel) {
        this.controlLevel = controlLevel == null ? null : controlLevel.trim();
    }

    /**
     * 获取开发商
     *
     * @return developers - 开发商
     */
    public String getDevelopers() {
        return developers;
    }

    /**
     * 设置开发商
     *
     * @param developers 开发商
     */
    public void setDevelopers(String developers) {
        this.developers = developers == null ? null : developers.trim();
    }

    /**
     * 获取执行时间
     *
     * @return do_time - 执行时间
     */
    public Date getDoTime() {
        return doTime;
    }

    /**
     * 设置执行时间
     *
     * @param doTime 执行时间
     */
    public void setDoTime(Date doTime) {
        this.doTime = doTime;
    }

    /**
     * 获取是否有监测
     *
     * @return has_monitor - 是否有监测
     */
    public String getHasMonitor() {
        return hasMonitor;
    }

    /**
     * 设置是否有监测
     *
     * @param hasMonitor 是否有监测
     */
    public void setHasMonitor(String hasMonitor) {
        this.hasMonitor = hasMonitor == null ? null : hasMonitor.trim();
    }

    /**
     * 获取采集时间
     *
     * @return data_time - 采集时间
     */
    public Date getDataTime() {
        return dataTime;
    }

    /**
     * 设置采集时间
     *
     * @param dataTime 采集时间
     */
    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    /**
     * 获取当前施工阶段编码
     *
     * @return engineering_stage_code - 当前施工阶段编码
     */
    public String getEngineeringStageCode() {
        return engineeringStageCode;
    }

    /**
     * 设置当前施工阶段编码
     *
     * @param engineeringStageCode 当前施工阶段编码
     */
    public void setEngineeringStageCode(String engineeringStageCode) {
        this.engineeringStageCode = engineeringStageCode == null ? null : engineeringStageCode.trim();
    }

    /**
     * 获取设备编码
     *
     * @return equipment_code - 设备编码
     */
    public String getEquipmentCode() {
        return equipmentCode;
    }

    /**
     * 设置设备编码
     *
     * @param equipmentCode 设备编码
     */
    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode == null ? null : equipmentCode.trim();
    }

    /**
     * 获取占地面积
     *
     * @return floor_area - 占地面积
     */
    public String getFloorArea() {
        return floorArea;
    }

    /**
     * 设置占地面积
     *
     * @param floorArea 占地面积
     */
    public void setFloorArea(String floorArea) {
        this.floorArea = floorArea == null ? null : floorArea.trim();
    }

    /**
     * 获取删除标志位
     *
     * @return jhpt_delete - 删除标志位
     */
    public String getJhptDelete() {
        return jhptDelete;
    }

    /**
     * 设置删除标志位
     *
     * @param jhptDelete 删除标志位
     */
    public void setJhptDelete(String jhptDelete) {
        this.jhptDelete = jhptDelete == null ? null : jhptDelete.trim();
    }

    /**
     * 获取噪声功能区
     *
     * @return noise_region - 噪声功能区
     */
    public String getNoiseRegion() {
        return noiseRegion;
    }

    /**
     * 设置噪声功能区
     *
     * @param noiseRegion 噪声功能区
     */
    public void setNoiseRegion(String noiseRegion) {
        this.noiseRegion = noiseRegion == null ? null : noiseRegion.trim();
    }

    /**
     * 获取负责人
     *
     * @return responsible - 负责人
     */
    public String getResponsible() {
        return responsible;
    }

    /**
     * 设置负责人
     *
     * @param responsible 负责人
     */
    public void setResponsible(String responsible) {
        this.responsible = responsible == null ? null : responsible.trim();
    }
}