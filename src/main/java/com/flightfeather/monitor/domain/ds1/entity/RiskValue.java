package com.flightfeather.monitor.domain.ds1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "du_js_t_risk_value")
public class RiskValue {
    @Id
    private Integer id;

    /**
     * 监测点编号
     */
    @Column(name = "mn_code")
    private String mnCode;

    /**
     * 时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "YYYY-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lst;

    /**
     * 在线率风险值
     */
    @Column(name = "online_risk")
    private Double onlineRisk;

    /**
     * 有效率风险值
     */
    @Column(name = "valid_risk")
    private Double validRisk;

    /**
     * 超标风险值
     */
    @Column(name = "exceed_risk")
    private Double exceedRisk;

    /**
     * 异常类型聚集度
     */
    @Column(name = "exception_type_aggregation")
    private Double exceptionTypeAggregation;

    /**
     * 典型异常复现率
     */
    @Column(name = "typical_exception_repetition_rate")
    private Double typicalExceptionRepetitionRate;

    /**
     * 统计类型（日统计或月统计）,day month
     */
    private String type;

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
     * 获取监测点编号
     *
     * @return mn_code - 监测点编号
     */
    public String getMnCode() {
        return mnCode;
    }

    /**
     * 设置监测点编号
     *
     * @param mnCode 监测点编号
     */
    public void setMnCode(String mnCode) {
        this.mnCode = mnCode == null ? null : mnCode.trim();
    }

    /**
     * 获取时间
     *
     * @return lst - 时间
     */
    public Date getLst() {
        return lst;
    }

    /**
     * 设置时间
     *
     * @param lst 时间
     */
    public void setLst(Date lst) {
        this.lst = lst;
    }

    /**
     * 获取在线率风险值
     *
     * @return online_risk - 在线率风险值
     */
    public Double getOnlineRisk() {
        return onlineRisk;
    }

    /**
     * 设置在线率风险值
     *
     * @param onlineRisk 在线率风险值
     */
    public void setOnlineRisk(Double onlineRisk) {
        this.onlineRisk = onlineRisk;
    }

    /**
     * 获取有效率风险值
     *
     * @return valid_risk - 有效率风险值
     */
    public Double getValidRisk() {
        return validRisk;
    }

    /**
     * 设置有效率风险值
     *
     * @param validRisk 有效率风险值
     */
    public void setValidRisk(Double validRisk) {
        this.validRisk = validRisk;
    }

    /**
     * 获取超标风险值
     *
     * @return exceed_risk - 超标风险值
     */
    public Double getExceedRisk() {
        return exceedRisk;
    }

    /**
     * 设置超标风险值
     *
     * @param exceedRisk 超标风险值
     */
    public void setExceedRisk(Double exceedRisk) {
        this.exceedRisk = exceedRisk;
    }

    /**
     * 获取异常类型聚集度
     *
     * @return exception_type_aggregation - 异常类型聚集度
     */
    public Double getExceptionTypeAggregation() {
        return exceptionTypeAggregation;
    }

    /**
     * 设置异常类型聚集度
     *
     * @param exceptionTypeAggregation 异常类型聚集度
     */
    public void setExceptionTypeAggregation(Double exceptionTypeAggregation) {
        this.exceptionTypeAggregation = exceptionTypeAggregation;
    }

    /**
     * 获取典型异常复现率
     *
     * @return typical_exception_repetition_rate - 典型异常复现率
     */
    public Double getTypicalExceptionRepetitionRate() {
        return typicalExceptionRepetitionRate;
    }

    /**
     * 设置典型异常复现率
     *
     * @param typicalExceptionRepetitionRate 典型异常复现率
     */
    public void setTypicalExceptionRepetitionRate(Double typicalExceptionRepetitionRate) {
        this.typicalExceptionRepetitionRate = typicalExceptionRepetitionRate;
    }

    /**
     * 获取统计类型（日统计或月统计）,day month
     *
     * @return type - 统计类型（日统计或月统计）,day month
     */
    public String getType() {
        return type;
    }

    /**
     * 设置统计类型（日统计或月统计）,day month
     *
     * @param type 统计类型（日统计或月统计）,day month
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}