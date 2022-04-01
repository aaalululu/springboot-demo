package com.chianlulu.springbootdemo.model;

import java.util.Date;

public class ProductSpu {

    private Integer productSpuId;
    private String productName;
    private Integer brandId;
    private Integer price;
    private Date createDate;
    private Date editDate;

    public Integer getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(Integer productSpuId) {
        this.productSpuId = productSpuId;
    }

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
