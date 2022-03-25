package com.chianlulu.springbootdemo.rowmapper;

import com.chianlulu.springbootdemo.model.Category;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

//<Category>表示要轉換成Category這個java class
public class CategoryRowMapper implements RowMapper<Category> {


    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        Category category = new Category();
        category.setCategoryId(resultSet.getInt("category_id"));
        category.setCategoryName(resultSet.getString("category_name"));
        category.setCreateDate(resultSet.getTimestamp("create_date"));
        category.setEditDate(resultSet.getTimestamp("edit_date"));
        return category;
    }
}
