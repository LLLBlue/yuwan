package com.blue.yw.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_config", schema = "yw", catalog = "")
public class SysConfigEntity {
    private int configId;
    private String configType;
    private String guideKey;
    private String paramValue;
    private String description;
    private String detail;
    private String state;
    private String sort;

    @Id
    @Column(name = "CONFIG_ID", nullable = false)
    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    @Basic
    @Column(name = "CONFIG_TYPE", nullable = true, length = 255)
    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    @Basic
    @Column(name = "GUIDE_KEY", nullable = true, length = 255)
    public String getGuideKey() {
        return guideKey;
    }

    public void setGuideKey(String guideKey) {
        this.guideKey = guideKey;
    }

    @Basic
    @Column(name = "PARAM_VALUE", nullable = true, length = 255)
    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "DETAIL", nullable = true, length = 255)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "STATE", nullable = true, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysConfigEntity that = (SysConfigEntity) o;
        return configId == that.configId &&
                Objects.equals(configType, that.configType) &&
                Objects.equals(guideKey, that.guideKey) &&
                Objects.equals(paramValue, that.paramValue) &&
                Objects.equals(description, that.description) &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(configId, configType, guideKey, paramValue, description, detail, state);
    }

    @Basic
    @Column(name = "SORT", nullable = true, length = 255)
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
