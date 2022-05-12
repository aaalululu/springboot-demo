package com.chianlulu.springbootdemo.model;

import org.springframework.beans.BeanUtils;

import java.util.Date;

public class SpuAndBrand {

    String brandName;
    String brandNameSub;
    private Integer spuId;
    private String spuName;
    private Integer brandId;
    private Integer categorySubId;
    private String imgUrl;
    private String spuInfo;
    private Integer price;
    private String isMarketable;
    private Date createDate;
    private Date editDate;

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

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCategorySubId() {
        return categorySubId;
    }

    public void setCategorySubId(Integer categorySubId) {
        this.categorySubId = categorySubId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSpuInfo() {
        return spuInfo;
    }

    public void setSpuInfo(String spuInfo) {
        this.spuInfo = spuInfo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
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
