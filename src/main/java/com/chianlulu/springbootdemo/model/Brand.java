package com.chianlulu.springbootdemo.model;

import java.util.Date;

public class Brand {
    Integer brandId;
    String brandName;
    String brandNameSub;
    Date createDate;
    Date editDate;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandNameSub() {
        return brandNameSub;
    }

    public void setBrandNameSub(String brandNameSub) {
        this.brandNameSub = brandNameSub;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }
}

