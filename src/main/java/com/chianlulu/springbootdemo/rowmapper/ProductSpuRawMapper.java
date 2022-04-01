package com.chianlulu.springbootdemo.rowmapper;

import com.chianlulu.springbootdemo.model.ProductSpu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSpuRawMapper implements RowMapper<ProductSpu> {


    @Override
    public ProductSpu mapRow(ResultSet resultSet, int irowNum) throws SQLException {
        ProductSpu productSpu = new ProductSpu();
        productSpu.setProductSpuId(resultSet.getInt("product_spu_id"));
        productSpu.setProductName(resultSet.getString("product_name"));
        productSpu.setBrandId(resultSet.getInt("brand_id"));
        productSpu.setPrice(resultSet.getInt("price"));
        productSpu.setCreateDate(resultSet.getTimestamp("create_date"));
        productSpu.setEditDate(resultSet.getTimestamp("edit_date"));
        return productSpu;
    }
}
