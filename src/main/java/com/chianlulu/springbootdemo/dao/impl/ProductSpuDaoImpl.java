package com.chianlulu.springbootdemo.dao.impl;

import com.chianlulu.springbootdemo.dao.ProductSpuDao;
import com.chianlulu.springbootdemo.dto.ProductSpuRequest;
import com.chianlulu.springbootdemo.model.ProductSpu;
import com.chianlulu.springbootdemo.rowmapper.ProductSpuRawMapper;
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
public class ProductSpuDaoImpl implements ProductSpuDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public ProductSpu getProductById(Integer productSpuId) {
        String sql="SELECT * FROM product_spu WHERE product_spu_id=:product_spu_id;";
        Map<String,Object> map = new HashMap<>();
        map.put("product_spu_id",productSpuId);

        List<ProductSpu> productSpuList = namedParameterJdbcTemplate.query(sql, map, new ProductSpuRawMapper());

        if(productSpuList!=null) {
            return productSpuList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer insertProduct(ProductSpuRequest productSpuRequest) {
        String sql="INSERT INTO product_spu (product_name,brand_id,price,create_date,edit_date) VALUES " +
                "(:product_name,:brand_id,:price,:create_date,:edit_date);";
        Date now = new Date();
        Map<String,Object> map = new HashMap<>();
        map.put("product_name",productSpuRequest.getProductName());
        map.put("brand_id",productSpuRequest.getBrandId());
        map.put("price",productSpuRequest.getPrice());
        map.put("create_date",now);
        map.put("edit_date",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        /* 帶有keyholder為參數的建構式,第二個參數只能是SqlParameterSource的類型
           故要用new MapSqlParameterSource進行轉換 */
        Integer productSpuId=namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder,new String[] {"product_spu_id"});

        return productSpuId;
    }

    @Override
    public void updateProduct(Integer productSpuId, ProductSpuRequest productSpuRequest,ProductSpu productSpu) {
        String sql="UPDATE product_spu SET product_name=:product_name,brand_id=:brand_id" +
                ",price=:price,edit_date=:edit_date WHERE product_spu_id=:product_spu_id;";
        Map<String,Object> map = new HashMap<>();
        Date now = new Date();
        map.put("product_name",productSpuRequest.getProductName()==null ? productSpu.getProductName(): productSpuRequest.getProductName());
        map.put("brand_id",productSpuRequest.getBrandId()==null ? productSpu.getBrandId() : productSpuRequest.getBrandId());
        map.put("price",productSpuRequest.getPrice()==null ? productSpu.getPrice() : productSpuRequest.getPrice());
        map.put("edit_date",now);
        map.put("product_spu_id",productSpuId);

        namedParameterJdbcTemplate.update(sql,map);

    }

    @Override
    public void deleteProduct(Integer productSpuId) {

    }
}
