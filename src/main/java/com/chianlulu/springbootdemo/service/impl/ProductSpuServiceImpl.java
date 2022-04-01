package com.chianlulu.springbootdemo.service.impl;

import com.chianlulu.springbootdemo.dao.ProductSpuDao;
import com.chianlulu.springbootdemo.dto.ProductSpuRequest;
import com.chianlulu.springbootdemo.model.ProductSpu;
import com.chianlulu.springbootdemo.service.ProductSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductSpuServiceImpl implements ProductSpuService {
    @Autowired
    private ProductSpuDao productSpuDao;

    @Override
    public ProductSpu getProductById(Integer product_spu_id) {
        return productSpuDao.getProductById(product_spu_id);
    }

    @Override
    public Integer insertProduct(ProductSpuRequest productSpuRequest) {
        return productSpuDao.insertProduct(productSpuRequest);
    }

    @Override
    public void updateProduct(Integer product_spu_id, ProductSpuRequest productSpuRequest,ProductSpu productSpu) {
        productSpuDao.updateProduct(product_spu_id,productSpuRequest,productSpu);
    }

    @Override
    public void deleteProduct(Integer product_spu_id) {

    }
}
