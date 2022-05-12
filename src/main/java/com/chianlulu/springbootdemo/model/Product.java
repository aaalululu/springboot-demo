package com.chianlulu.springbootdemo.model;

import java.util.Date;

public class Product {
    private Integer spuId;//sku的fk
    private String spuName;
    private Integer brandId;
    private Integer categorySubId;
    private String imgUrl;
    private String spuInfo;
    private Integer price;
    private String isMarketable;
    private Date createDateSpu;
    private Date editDateSpu;
    private Integer skuId;
    private String gender;
    private String color;
    private String skuSize;
    private Integer stock;
    private String pCode;
    private Date createDateSku;
    private Date editDateSku;

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

    public Date getCreateDateSpu() {
        return createDateSpu;
    }

    public void setCreateDateSpu(Date createDateSpu) {
        this.createDateSpu = createDateSpu;
    }

    public Date getEditDateSpu() {
        return editDateSpu;
    }

    public void setEditDateSpu(Date editDateSpu) {
        this.editDateSpu = editDateSpu;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSkuSize() {
        return skuSize;
    }

    public void setSkuSize(String skuSize) {
        this.skuSize = skuSize;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public Date getCreateDateSku() {
        return createDateSku;
    }

    public void setCreateDateSku(Date createDateSku) {
        this.createDateSku = createDateSku;
    }

    public Date getEditDateSku() {
        return editDateSku;
    }

    public void setEditDateSku(Date editDateSku) {
        this.editDateSku = editDateSku;
    }
}
