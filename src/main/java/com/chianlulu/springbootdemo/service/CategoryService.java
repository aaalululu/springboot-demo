package com.chianlulu.springbootdemo.service;

import com.chianlulu.springbootdemo.dto.CategoryRequest;
import com.chianlulu.springbootdemo.model.Category;

public interface CategoryService {

    Category getCategoryById(Integer categoryId);
    Integer insertCategory(CategoryRequest categoryRequest);
    void updateCategory(Integer categoryId,CategoryRequest categoryRequest);

}
