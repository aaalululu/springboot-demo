package com.chianlulu.springbootdemo.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


public class CategoryRequest {

    @NotNull
    String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
