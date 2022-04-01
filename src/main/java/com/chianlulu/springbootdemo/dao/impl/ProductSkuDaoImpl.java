package com.chianlulu.springbootdemo.dao.impl;

import com.chianlulu.springbootdemo.dao.ProductSkuDao;
import com.chianlulu.springbootdemo.dto.ProductSkuRequest;
import com.chianlulu.springbootdemo.model.ProductSku;
import com.chianlulu.springbootdemo.rowmapper.ProductSkuRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductSkuDaoImpl implements ProductSkuDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<ProductSku> getProductSkuById(Integer integer) {


        return null;
    }

    @Override
    public List<ProductSku> getProductSkuByIdAndColor(Integer product_spu_id, String color) {
        String sql="SELECT product_spu_id, color,size, stock, create_date, edit_date " +
                "FROM public.product_sku WHERE :product_spu_id AND :color";

        Map<String,Object> map = new HashMap<>();
        map.put("product_spu_id",product_spu_id);
        map.put("color",color);

        List<ProductSku> productSkuList = namedParameterJdbcTemplate.query(sql, map, new ProductSkuRowMapper());

        return null;
    }

    @Override
    public ProductSku getProductSkuByIdAndColorAndSize(Integer product_spu_id, String color, String size) {
        String sql="SELECT product_spu_id, color,size, stock, create_date, edit_date " +
                "FROM public.product_sku WHERE :product_spu_id AND :color AND :size";

        Map<String,Object> map = new HashMap<>();
        map.put("product_spu_id",product_spu_id);
        map.put("color",color);
        map.put("size",size);

        List<ProductSku> productSkuList = namedParameterJdbcTemplate.query(sql, map, new ProductSkuRowMapper());
        if(productSkuList != null) {
            return productSkuList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer insertProductSku(ProductSkuRequest productSkuRequest) {
        String sql="INSERT INTO product_sku (product_spu_id, color, size, stock, create_date, edit_date) " +
                "VALUES (:product_spu_id, :color, :size, :stock, :create_date, :edit_date);";

        Map<String,Object> map = new HashMap<>();
        Date now = new Date();
        map.put("product_spu_id",productSkuRequest.getProductSpuId());
        map.put("color",productSkuRequest.getColor());
        map.put("stock",productSkuRequest.getStock());
        map.put("create_date",now);
        map.put("edit_date",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        Integer productSkuId = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder, new String[]{"product_sku_id"});

        return productSkuId;
    }
}
