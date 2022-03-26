package com.chianlulu.springbootdemo.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class BrandRequest {

    @NotNull
    private String brandName;
    private String brandNameSub;

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
}
