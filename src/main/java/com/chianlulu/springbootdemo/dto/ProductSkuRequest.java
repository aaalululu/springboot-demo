package com.chianlulu.springbootdemo.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Component
public class ProductSkuRequest {
    @NotNull
    Integer productSpuId;
    String color;
    String size;
    @Min(0)
    Integer stock;
    Date createDate;
    Date editDate;

    public Integer getProductSpuId() {
        return productSpuId;
    }

    public void setProductSpuId(Integer productSpuId) {
        this.productSpuId = productSpuId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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
