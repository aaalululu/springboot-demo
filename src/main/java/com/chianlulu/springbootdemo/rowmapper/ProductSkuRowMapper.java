package com.chianlulu.springbootdemo.rowmapper;

import com.chianlulu.springbootdemo.model.ProductSku;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSkuRowMapper implements RowMapper<ProductSku> {

    @Override
    public ProductSku mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductSku productSku = new ProductSku();
        productSku.setSkuId(resultSet.getInt("sku_id"));
        productSku.setSpuId(resultSet.getInt("spu_id"));
        productSku.setGender(resultSet.getString("gender"));
        productSku.setColor(resultSet.getString("color"));
        productSku.setSkuSize(resultSet.getString("sku_size"));
        productSku.setStock(resultSet.getInt("stock"));
        productSku.setpCode(resultSet.getString("p_code"));
        productSku.setCreateDate(resultSet.getDate("create_date"));
        productSku.setEditDate(resultSet.getDate("edit_date"));
        return productSku;
    }
}
