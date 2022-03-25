package com.chianlulu.springbootdemo.dao;

import com.chianlulu.springbootdemo.dto.CategoryRequest;
import com.chianlulu.springbootdemo.model.Category;

public interface CategoryDao {

    Category getCategoryById(Integer categoryId);
    Integer insertCategory(CategoryRequest categoryRequest);
    void updateCategory(Integer categoryId,CategoryRequest categoryRequest);

}
