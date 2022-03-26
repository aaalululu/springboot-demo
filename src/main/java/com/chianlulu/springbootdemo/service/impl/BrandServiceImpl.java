package com.chianlulu.springbootdemo.service.impl;

import com.chianlulu.springbootdemo.dao.BrandDao;
import com.chianlulu.springbootdemo.dto.BrandRequest;
import com.chianlulu.springbootdemo.model.Brand;
import com.chianlulu.springbootdemo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public Brand getBrandById(Integer brandId) {
        return brandDao.getBrandById(brandId);
    }

    @Override
    public Integer insertBrand(BrandRequest brandRequest) {
        return brandDao.insertBrand(brandRequest);
    }

    @Override
    public void updateBrand(Integer brandId,BrandRequest brandRequest) {
        brandDao.updateBrand(brandId,brandRequest);
    }

    @Override
    public void deleteBrandById(Integer brandId) {
        brandDao.deleteBrandById(brandId);
    }

}
