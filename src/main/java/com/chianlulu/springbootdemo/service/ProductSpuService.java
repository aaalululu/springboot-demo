package com.chianlulu.springbootdemo.service;

import com.chianlulu.springbootdemo.dto.ProductSpuRequest;
import com.chianlulu.springbootdemo.model.ProductSpu;

public interface ProductSpuService {
    ProductSpu getProductById(Integer product_spu_id);
    Integer insertProduct(ProductSpuRequest productSpuRequest);
    void updateProduct(Integer product_spu_id,ProductSpuRequest productSpuRequest,ProductSpu productSpu);
    void deleteProduct(Integer product_spu_id);
}
