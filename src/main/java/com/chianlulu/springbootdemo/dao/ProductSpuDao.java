package com.chianlulu.springbootdemo.dao;

import com.chianlulu.springbootdemo.dto.ProductSpuRequest;
import com.chianlulu.springbootdemo.model.ProductSpu;

public interface ProductSpuDao {

    ProductSpu getProductById(Integer product_spu_id);
    Integer insertProduct(ProductSpuRequest productSpuRequest);
    void updateProduct(Integer product_spu_id,ProductSpuRequest productSpuRequest,ProductSpu productSpu);
    void deleteProduct(Integer product_spu_id);

}
