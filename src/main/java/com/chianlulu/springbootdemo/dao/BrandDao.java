package com.chianlulu.springbootdemo.dao;

import com.chianlulu.springbootdemo.dto.BrandRequest;
import com.chianlulu.springbootdemo.model.Brand;

import java.util.List;

public interface BrandDao {

    Brand getBrandById(Integer brandId);
    List<Brand> getBrands(String search);
    Integer insertBrand(BrandRequest brandRequest);
    void updateBrand(Integer brandId,BrandRequest brandRequest);
    void deleteBrandById(Integer brandId);
}
