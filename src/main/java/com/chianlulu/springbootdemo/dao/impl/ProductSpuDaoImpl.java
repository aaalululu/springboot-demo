package com.chianlulu.springbootdemo.dao.impl;

import com.chianlulu.springbootdemo.dao.ProductSpuDao;
import com.chianlulu.springbootdemo.dto.ProductSpuQueryParam;
import com.chianlulu.springbootdemo.dto.ProductSpuRequest;
import com.chianlulu.springbootdemo.model.ProductSpu;
import com.chianlulu.springbootdemo.model.SpuAndBrand;
import com.chianlulu.springbootdemo.rowmapper.ProductSpuRawMapper;
import com.chianlulu.springbootdemo.rowmapper.SpuAndBrandRowMapper;
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

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    String newLine=System.getProperty("line.separator");

    @Override
    public ProductSpu getProductById(Integer spuId) {
        String sql="SELECT a.* FROM public.product_spu AS a WHERE a.spu_id=:spu_id;";
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
    public List<ProductSpu> getProductSpuList(ProductSpuQueryParam productSpuQueryParam) {
        StringBuilder sql=getProductSpuListSql();
        Map<String,Object> map= new HashMap<>();
        if(productSpuQueryParam.getSearch() != null) {
            sql.append(" AND product_spu.spu_name LIKE :search");
            map.put("search","%"+productSpuQueryParam.getSearch()+"%");
        }
        if(productSpuQueryParam.getBrandName() != null) {
            sql.append(" AND brand.brand_name LIKE :brandName");
            map.put("brandName","%"+productSpuQueryParam.getBrandName()+"%");
        }

        if(productSpuQueryParam.getOrderBy() == null) {
            sql.append(" ORDER BY product_spu.edit_date");
        } else {
            sql.append(" ORDER BY ").append(productSpuQueryParam.getOrderBy());
        }

        if(productSpuQueryParam.getSort() == null) {
            sql.append(" DESC");
        } else {
            sql.append(" :sort");
            map.put("sort",productSpuQueryParam.getSort());
        }

        return namedParameterJdbcTemplate.query(sql.toString(),map,new ProductSpuRawMapper());
    }

    private StringBuilder getProductSpuListSql() {
        StringBuilder sql=new StringBuilder();
        sql.append("SELECT product_spu.spu_id,product_spu.spu_name,product_spu.brand_id").append(newLine);
        sql.append(",brand.brand_name,product_spu.category_sub_id,product_spu.img_url").append(newLine);
        sql.append(",product_spu.spu_info,product_spu.price,product_spu.is_marketable").append(newLine);
        sql.append(",product_spu.create_date,product_spu.edit_date").append(newLine);
        sql.append("FROM public.product_spu AS product_spu").append(newLine);
        sql.append("JOIN public.brand AS brand").append(newLine);
        sql.append("ON product_spu.brand_id=brand.brand_id").append(newLine);
        sql.append("WHERE 1=1").append(newLine);

        return sql;
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
        int productSpuId;
        productSpuId = namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder,new String[] {"spu_id"});

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
