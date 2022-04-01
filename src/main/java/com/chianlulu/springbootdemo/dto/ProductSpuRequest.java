package com.chianlulu.springbootdemo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductSpuRequest {

    @NotNull
    private String productName;
    private Integer brandId;
    @Min(0)
    private Integer price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
