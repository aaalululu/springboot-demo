package com.chianlulu.springbootdemo.dao.impl;

import com.chianlulu.springbootdemo.dao.CategoryDao;
import com.chianlulu.springbootdemo.dto.CategoryRequest;
import com.chianlulu.springbootdemo.model.Category;
import com.chianlulu.springbootdemo.rowmapper.CategoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryDaoImpl implements CategoryDao {

    @Autowired //spring jdbc創建
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Category getCategoryById(Integer categoryId) {
        String sql="SELECT category_id,category_name,create_date,edit_date FROM category WHERE category_id = :categoryId;";
        Map<String,Object> map = new HashMap<>();
        map.put("categoryId",categoryId);
        List<Category> categoryList = namedParameterJdbcTemplate.query(sql, map, new CategoryRowMapper());
        if(categoryList.size()>0) {
            return categoryList.get(0);
        } else {
            return null;
        }

    }


    @Override
    public Integer insertCategory(CategoryRequest categoryRequest) {
        String sql="INSERT INTO category (category_name,create_date,edit_date) VALUES (:categoryName,:createDate,:editDate);";
        Map<String,Object> map = new HashMap<>();
        Date now = new Date();

        map.put("categoryName",categoryRequest.getCategoryName());
        map.put("createDate",now);
        map.put("editDate",now);
        
        //Spring利用GeneratedKeyHolder，提供了一个可以返回新增记录对应主键值的方法
        KeyHolder keyHolder = new GeneratedKeyHolder();


        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder,new String[] {"category_id"});

        int categoryId = keyHolder.getKey().intValue();

        return categoryId;
    }

    @Override
    public void updateCategory(Integer categoryId, CategoryRequest categoryRequest) {
        String sql="UPDATE category SET category_name=:categoryName,edit_date=:editDate WHERE category_id=:categoryId;";

        Map<String,Object> map = new HashMap<>();
        Date now = new Date();
        map.put("categoryId",categoryId);
        map.put("categoryName",categoryRequest.getCategoryName());
        map.put("editDate",now);

        namedParameterJdbcTemplate.update(sql,map);

    }
}
