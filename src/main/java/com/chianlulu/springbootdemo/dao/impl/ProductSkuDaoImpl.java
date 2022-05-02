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
    public List<ProductSku> getProductBySpuIdAndGender(Integer integer, String gender) {
        return null;
    }

    @Override
    public List<ProductSku> getProductBySpuIdAndGenderAndColor(Integer spu_id, String gender, String color) {

        String sql = "SELECT sku_id,spu_id,gender,color,sku_size, stock, create_date, edit_date " +
                "FROM public.product_sku " +
                "WHERE :spu_id AND :gender AND :color";

        Map<String, Object> map = new HashMap<>();
        map.put("spu_id", spu_id);
        map.put("gender",gender);
        map.put("color", color);

        List<ProductSku> productSkuList = namedParameterJdbcTemplate.query(sql, map, new ProductSkuRowMapper());

        if(productSkuList.size()>0) {
            return productSkuList;
        } else {
            return null;
        }

    }

    @Override
    public ProductSku getProductSkuByAll(Integer spu_id,String gender, String color, String skuSize) {
        String sql="SELECT spu_id, color,sku_size, stock, create_date, edit_date " +
                "FROM public.product_sku WHERE :product_spu_id AND :color AND :size";

        Map<String,Object> map = new HashMap<>();
        map.put("spu_id",spu_id);
        map.put("color",color);
        map.put("sku_size",skuSize);

        List<ProductSku> productSkuList = namedParameterJdbcTemplate.query(sql, map, new ProductSkuRowMapper());
        if(productSkuList.size()>0) {
            return productSkuList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer insertProductSku(ProductSkuRequest productSkuRequest) {
        String sql="INSERT INTO product_sku (spu_id, color, sku_size, stock, create_date, edit_date) " +
                "VALUES (:spu_id, :color, :size, :stock, :create_date, :edit_date);";

        Map<String,Object> map = new HashMap<>();
        Date now = new Date();
        map.put("spu_id",productSkuRequest.getSpuId());
        map.put("color",productSkuRequest.getColor());
        map.put("stock",productSkuRequest.getStock());
        map.put("create_date",now);
        map.put("edit_date",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        Integer productSkuId = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder, new String[]{"product_sku_id"});

        return productSkuId;
    }
}
