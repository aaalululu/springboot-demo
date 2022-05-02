package com.chianlulu.springbootdemo.rowmapper;

import com.chianlulu.springbootdemo.model.ProductSpu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSpuRawMapper implements RowMapper<ProductSpu> {


    @Override
    public ProductSpu mapRow(ResultSet resultSet, int irowNum) throws SQLException {
        ProductSpu productSpu = new ProductSpu();
        productSpu.setSpuId(resultSet.getInt("spu_id"));
        productSpu.setSpuName(resultSet.getString("spu_name"));
        productSpu.setBrandId(resultSet.getInt("brand_id"));
        productSpu.setCategorySubId(resultSet.getInt("category_sub_id"));
        productSpu.setImgUrl(resultSet.getString("img_url"));
        productSpu.setSpuInfo(resultSet.getString("spu_info"));
        productSpu.setPrice(resultSet.getInt("price"));
        productSpu.setIsMarketable(resultSet.getString("is_marketable"));
        productSpu.setCreateDate(resultSet.getTimestamp("create_date"));
        productSpu.setEditDate(resultSet.getTimestamp("edit_date"));
        return productSpu;
    }
}
