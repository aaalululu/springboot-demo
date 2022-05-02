package com.chianlulu.springbootdemo.dao;

import com.chianlulu.springbootdemo.dto.ProductSpuRequest;
import com.chianlulu.springbootdemo.model.ProductSpu;

import java.util.List;

public interface ProductSpuDao {

    ProductSpu getProductById(Integer product_spu_id);
    List<ProductSpu> getProductSpuList(String search);
    Integer insertProduct(ProductSpuRequest productSpuRequest);
    void updateProduct(Integer product_spu_id,ProductSpuRequest productSpuRequest,ProductSpu productSpu);
    void deleteProductSpuById(Integer product_spu_id);

}
