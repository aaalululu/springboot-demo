package com.chianlulu.springbootdemo.controller;

import com.chianlulu.springbootdemo.dto.ProductSpuRequest;
import com.chianlulu.springbootdemo.model.ProductSpu;
import com.chianlulu.springbootdemo.service.ProductSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductSpuController {

    @Autowired
    private ProductSpuService productSpuService;

    @GetMapping("/product_spu/{product_spu_id}")
    public ResponseEntity<ProductSpu> getProductById(@PathVariable Integer product_spu_id) {
        ProductSpu productSpu=productSpuService.getProductById(product_spu_id);
        if(productSpu!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(productSpu);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/product_spu")
    public ResponseEntity<ProductSpu> insertProduct(@RequestBody ProductSpuRequest productSpuRequest) {
        Integer product_spu_id=productSpuService.insertProduct(productSpuRequest);
        if(product_spu_id!=null) {
            ProductSpu productSpu=productSpuService.getProductById(product_spu_id);
            return ResponseEntity.status(HttpStatus.CREATED).body(productSpu);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/product_spu/{product_spu_id}")
    public ResponseEntity<ProductSpu> updateProduct(@PathVariable Integer product_spu_id,
                                                    @RequestBody ProductSpuRequest productSpuRequest) {
        ProductSpu productSpuOld=productSpuService.getProductById(product_spu_id);
        productSpuService.updateProduct(product_spu_id,productSpuRequest,productSpuOld);
        ProductSpu productSpu=productSpuService.getProductById(product_spu_id);
        if(productSpu!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(productSpu);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
