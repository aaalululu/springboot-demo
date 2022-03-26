package com.chianlulu.springbootdemo.dao.impl;

import com.chianlulu.springbootdemo.dao.BrandDao;
import com.chianlulu.springbootdemo.dto.BrandRequest;
import com.chianlulu.springbootdemo.model.Brand;
import com.chianlulu.springbootdemo.rowmapper.BrandRowMapper;
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
public class BrandDaoImpl implements BrandDao {
    String newLine=System.getProperty("line.separator");

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Brand getBrandById(Integer brandId) {
        String sql="SELECT brand_id,brand_name,brand_name_sub,create_date,edit_date FROM brand WHERE brand_id=:brand_id";
        Map<String, Object> map=new HashMap<>();
        map.put("brand_id",brandId);

        List<Brand> brandList = namedParameterJdbcTemplate.query(sql, map, new BrandRowMapper());
        if(brandList.size()>0) {
            return brandList.get(0);
        } else {
            return null;
        }
    }

    public Integer insertBrand(BrandRequest brandRequest) {
        String sql="INSERT INTO brand (brand_name,brand_name_sub,create_date,edit_date) VALUES (:brand_name,:brand_name_sub,:create_date,:edit_date);";
        Map<String,Object> map = new HashMap<>();
        Date now = new Date();
        map.put("brand_name",brandRequest.getBrandName());
        map.put("brand_name_sub",brandRequest.getBrandNameSub());
        map.put("create_date",now);
        map.put("edit_date",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder,new String[] {"brand_id"});
        int brandId=keyHolder.getKey().intValue();
        return brandId;
    }

    public void updateBrand(Integer brandId,BrandRequest brandRequest) {
        String sql="UPDATE brand SET brand_name=:brand_name,brand_name_sub=:brand_name_sub,edit_date=:edit_date WHERE brand_id=:brand_id";
        Map<String,Object> map = new HashMap<>();
        Date now = new Date();
        map.put("brand_name",brandRequest.getBrandName());
        map.put("brand_name_sub",brandRequest.getBrandNameSub());
        map.put("brand_id",brandId);
        map.put("edit_date",now);

        namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public void deleteBrandById(Integer brandId) {
        String sql="DELETE FROM brand WHERE brand_id=:brand_id;";
        Map<String,Object> map = new HashMap<>();
        map.put("brand_id",brandId);

        namedParameterJdbcTemplate.update(sql,map);
    }

}
