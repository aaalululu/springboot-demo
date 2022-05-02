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
    public ProductSpu getProductById(Integer spuId) {
        String sql="SELECT * FROM public.product_spu WHERE spu_id=:spu_id;";
        Map<String,Object> map = new HashMap<>();
        map.put("spu_id",spuId);

        List<ProductSpu> productSpuList = namedParameterJdbcTemplate.query(sql, map, new ProductSpuRawMapper());

        if(productSpuList.size()>0) {
            return productSpuList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<ProductSpu> getProductSpuList(String search) {
        StringBuilder sql=new StringBuilder();
        sql.append("SELECT * FROM public.product_spu WHERE 1=1 ");
        Map<String,Object> map= new HashMap<>();
        if(search != null) {
            sql.append(" AND spu_name LIKE :search");
            map.put("search","%"+search+"%");
        }
        List<ProductSpu> productSpuLists = namedParameterJdbcTemplate.query(sql.toString(),map,new ProductSpuRawMapper());
        return productSpuLists;
    }

    @Override
    public Integer insertProduct(ProductSpuRequest productSpuRequest) {
        String sql="INSERT INTO public.product_spu (spu_name,brand_id,category_sub_id,price,create_date,edit_date) VALUES " +
                "(:spu_name,:brand_id,:category_sub_id,:price,:create_date,:edit_date);";
        Date now = new Date();
        Map<String,Object> map = new HashMap<>();
        map.put("spu_name",productSpuRequest.getSpuName());
        map.put("brand_id",productSpuRequest.getBrandId());
        map.put("category_sub_id",productSpuRequest.getCategorySubId());
        map.put("price",productSpuRequest.getPrice());
        map.put("create_date",now);
        map.put("edit_date",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        /* 帶有keyholder為參數的建構式,第二個參數只能是SqlParameterSource的類型
           故要用new MapSqlParameterSource進行轉換 */
        Integer productSpuId=namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder,new String[] {"spu_id"});

        return productSpuId;
    }

    @Override
    public void updateProduct(Integer spuId, ProductSpuRequest productSpuRequest,ProductSpu productSpu) {
        String sql="UPDATE product_spu SET spu_name=:spu_name,brand_id=:brand_id" +
                ",category_sub_id=:category_sub_id,price=:price,edit_date=:edit_date " +
                "WHERE spu_id=:spuId;";
        Map<String,Object> map = new HashMap<>();
        Date now = new Date();
        map.put("spu_name",productSpuRequest.getSpuName()==null ? productSpu.getSpuName(): productSpuRequest.getSpuName());
        map.put("brand_id",productSpuRequest.getBrandId()==null ? productSpu.getBrandId() : productSpuRequest.getBrandId());
        map.put("category_sub_id", productSpuRequest.getCategorySubId()== null ? productSpu.getCategorySubId() : productSpuRequest.getCategorySubId());
        map.put("price",productSpuRequest.getPrice()==null ? productSpu.getPrice() : productSpuRequest.getPrice());
        map.put("edit_date",now);
        map.put("spu_id",spuId);

        namedParameterJdbcTemplate.update(sql,map);

    }

    @Override
    public void deleteProductSpuById(Integer product_spu_id) {
        String sql="DELETE FROM product_spu WHERE spu_id=:product_spu_id;";
        Map<String,Object> map = new HashMap<>();
        map.put("product_spu_id",product_spu_id);

        namedParameterJdbcTemplate.update(sql,map);
    }
}
