package com.chianlulu.springbootdemo.service;

import com.chianlulu.springbootdemo.dto.BrandRequest;
import com.chianlulu.springbootdemo.model.Brand;

import java.util.List;

public interface BrandService {
    Brand getBrandById(Integer brandId);
    List<Brand> getBrands(String search);
    Integer insertBrand(BrandRequest brandRequest);
    void updateBrand(Integer brandId,BrandRequest brandRequest);
    void deleteBrandById(Integer brandId);
}
