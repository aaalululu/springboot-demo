package com.chianlulu.springbootdemo.rowmapper;

import com.chianlulu.springbootdemo.model.Brand;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRowMapper implements RowMapper<Brand> {
    @Override
    public Brand mapRow(ResultSet resultSet, int i) throws SQLException {
        Brand brand = new Brand();
        brand.setBrandId(resultSet.getInt("brand_id"));
        brand.setBrandName(resultSet.getString("brand_name"));
        brand.setBrandNameSub(resultSet.getString("brand_name_sub"));
        brand.setCreateDate(resultSet.getTimestamp("create_date"));
        brand.setEditDate(resultSet.getTimestamp("edit_date"));
        return brand;
    }
}
