package com.flightfeather.monitor.domain.ds1.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ja_t_dust_site_data_info")
public class DustSiteData {
    @Id
    private Integer id;

    @Column(name = "mn_code")
    private String mnCode;

    @Column(name = "dust_value")
    private Double dustValue;

    @Column(name = "noise_value")
    private Double noiseValue;

    private Date lst;

    private String quality;

    private Integer grade;

    private String flag;

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
     * @return dust_value
     */
    public Double getDustValue() {
        return dustValue;
    }

    /**
     * @param dustValue
     */
    public void setDustValue(Double dustValue) {
        this.dustValue = dustValue;
    }

    /**
     * @return noise_value
     */
    public Double getNoiseValue() {
        return noiseValue;
    }

    /**
     * @param noiseValue
     */
    public void setNoiseValue(Double noiseValue) {
        this.noiseValue = noiseValue;
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
     * @return quality
     */
    public String getQuality() {
        return quality;
    }

    /**
     * @param quality
     */
    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    /**
     * @return grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * @param grade
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * @return flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}