package com.chianlulu.springbootdemo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductSpuRequest {

    @NotNull
    private String spuName;
    @NotNull
    private Integer brandId;
    private Integer categorySubId;
    @Min(0)
    private Integer price;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
