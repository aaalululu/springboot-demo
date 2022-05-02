package com.chianlulu.springbootdemo.dao;

import com.chianlulu.springbootdemo.dto.ProductSkuRequest;
import com.chianlulu.springbootdemo.model.ProductSku;

import java.util.List;

public interface ProductSkuDao {
//    String newLine=System.lineSeparator();
    List<ProductSku> getProductBySpuIdAndGender(Integer integer, String gender);
    List<ProductSku> getProductBySpuIdAndGenderAndColor(Integer integer, String gender,String color);
    ProductSku getProductSkuByAll(Integer integer, String gender,String color, String size);
    Integer insertProductSku(ProductSkuRequest productSkuRequest);


}
