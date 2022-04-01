package com.chianlulu.springbootdemo.dao;

import com.chianlulu.springbootdemo.dto.ProductSkuRequest;
import com.chianlulu.springbootdemo.model.ProductSku;

import java.util.List;

public interface ProductSkuDao {
    List<ProductSku> getProductSkuById(Integer integer);
    List<ProductSku> getProductSkuByIdAndColor(Integer integer, String color);
    ProductSku getProductSkuByIdAndColorAndSize(Integer integer, String color, String size);
    Integer insertProductSku(ProductSkuRequest productSkuRequest);


}
