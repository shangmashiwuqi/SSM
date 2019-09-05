package com.shangma.cn.entity;

public class Customer {
    private Long custId;

    private String custName;

    private String custSource;
    private String custSourceName;

    private String custIndustry;
    private String custIndustryName;

    private String custLevel;

    public String getCustSourceName() {
        return custSourceName;
    }

    public void setCustSourceName(String custSourceName) {
        this.custSourceName = custSourceName;
    }

    public String getCustIndustryName() {
        return custIndustryName;
    }

    public void setCustIndustryName(String custIndustryName) {
        this.custIndustryName = custIndustryName;
    }

    public String getCustLevelName() {
        return custLevelName;
    }

    public void setCustLevelName(String custLevelName) {
        this.custLevelName = custLevelName;
    }

    private String custLevelName;

    private String custPhone;

    private String custMobile;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource == null ? null : custSource.trim();
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry == null ? null : custIndustry.trim();
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel == null ? null : custLevel.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile == null ? null : custMobile.trim();
    }
}