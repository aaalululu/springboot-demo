package com.chianlulu.springbootdemo.rowmapper;

import com.chianlulu.springbootdemo.model.ProductSku;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSkuRowMapper implements RowMapper<ProductSku> {

    @Override
    public ProductSku mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductSku productSku = new ProductSku();
        productSku.setProductSkuId(resultSet.getInt("product_sku_id"));
        productSku.setColor(resultSet.getString("color"));
        productSku.setSize(resultSet.getString("size"));
        productSku.setStock(resultSet.getInt("stock"));
        productSku.setCreateDate(resultSet.getDate("create_date"));
        productSku.setEditDate(resultSet.getDate("edit_date"));
        return null;
    }
}
