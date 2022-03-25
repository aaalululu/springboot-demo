package com.chianlulu.springbootdemo.service.impl;

import com.chianlulu.springbootdemo.dao.CategoryDao;
import com.chianlulu.springbootdemo.dao.impl.CategoryDaoImpl;
import com.chianlulu.springbootdemo.dto.CategoryRequest;
import com.chianlulu.springbootdemo.model.Category;
import com.chianlulu.springbootdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryDao.getCategoryById(categoryId);
    }

    @Override
    public Integer insertCategory(CategoryRequest categoryRequest) {
        return categoryDao.insertCategory(categoryRequest);
    }

    @Override
    public void updateCategory(Integer categoryId, CategoryRequest categoryRequest) {
        categoryDao.updateCategory(categoryId,categoryRequest);

    }
}
