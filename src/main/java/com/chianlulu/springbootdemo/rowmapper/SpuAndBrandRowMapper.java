package com.chianlulu.springbootdemo.rowmapper;

import com.chianlulu.springbootdemo.model.Brand;
import com.chianlulu.springbootdemo.model.ProductSpu;
import com.chianlulu.springbootdemo.model.SpuAndBrand;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpuAndBrandRowMapper implements RowMapper<SpuAndBrand> {

    @Override
    public SpuAndBrand mapRow(ResultSet resultSet, int i) throws SQLException {
        SpuAndBrand spuAndBrand= new SpuAndBrand();
        spuAndBrand.setBrandName(resultSet.getString("brand_name"));
        spuAndBrand.setBrandNameSub(resultSet.getString("brand_name_sub"));
        spuAndBrand.setSpuId(resultSet.getInt("spu_id"));
        spuAndBrand.setSpuName(resultSet.getString("spu_name"));
        spuAndBrand.setBrandId(resultSet.getInt("brand_id"));
        spuAndBrand.setCategorySubId(resultSet.getInt("category_sub_id"));
        spuAndBrand.setImgUrl(resultSet.getString("img_url"));
        spuAndBrand.setSpuInfo(resultSet.getString("spu_info"));
        spuAndBrand.setPrice(resultSet.getInt("price"));
        spuAndBrand.setIsMarketable(resultSet.getString("is_marketable"));
        spuAndBrand.setCreateDate(resultSet.getTimestamp("create_date"));
        spuAndBrand.setEditDate(resultSet.getTimestamp("edit_date"));
        return spuAndBrand;
    }


}
