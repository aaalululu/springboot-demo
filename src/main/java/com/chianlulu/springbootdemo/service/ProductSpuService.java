package com.chianlulu.springbootdemo.service;

import com.chianlulu.springbootdemo.dto.ProductSpuQueryParam;
import com.chianlulu.springbootdemo.dto.ProductSpuRequest;
import com.chianlulu.springbootdemo.model.ProductSpu;

import java.util.List;

public interface ProductSpuService {
    ProductSpu getProductById(Integer product_spu_id);
    List<ProductSpu> getProductSpuList(ProductSpuQueryParam productSpuQueryParam);
    Integer insertProduct(ProductSpuRequest productSpuRequest);
    void updateProduct(Integer product_spu_id,ProductSpuRequest productSpuRequest,ProductSpu productSpu);
    void deleteProductSpuById(Integer product_spu_id);
}
