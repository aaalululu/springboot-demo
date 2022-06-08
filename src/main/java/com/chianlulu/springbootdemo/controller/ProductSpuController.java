package com.chianlulu.springbootdemo.controller;

import com.chianlulu.springbootdemo.dto.ProductSpuQueryParam;
import com.chianlulu.springbootdemo.dto.ProductSpuRequest;
import com.chianlulu.springbootdemo.model.ProductSpu;
import com.chianlulu.springbootdemo.service.ProductSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductSpuController {

    @Autowired
    private ProductSpuService productSpuService;


/*
    @RequestMapping("/product_spu")
    public ResponseEntity<List<ProductSpu>> getProductSpus(
            @RequestParam(required = false) String search ,
            @RequestParam(required = false) String brandName,
            @RequestParam(defaultValue = " product_spu.spu_id") String orderBy,
            @RequestParam(defaultValue = " desc") String sort,
            Model model){
        ProductSpuQueryParam productSpuQueryParam = new ProductSpuQueryParam();
        productSpuQueryParam.setSearch(search);
        productSpuQueryParam.setBrandName(brandName);
        productSpuQueryParam.setOrderBy(orderBy);
        productSpuQueryParam.setSort(sort);
        List<ProductSpu> productSpuList=productSpuService.getProductSpuList(productSpuQueryParam);

        return ResponseEntity.status(HttpStatus.OK).body(productSpuList);
    }
*/


/*  //RestFul
    @GetMapping("/product_spu/{product_spu_id}")
    public ResponseEntity<ProductSpu> getProductById(@PathVariable Integer product_spu_id) {
        ProductSpu productSpu=productSpuService.getProductById(product_spu_id);
        if(productSpu!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(productSpu);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    } */

    //Thymeleaf 練習PathVariable
    @RequestMapping("/product_spu/{product_spu_id}")
    public String getProductById(@PathVariable Integer product_spu_id,Model model) {
        ProductSpu productSpu = productSpuService.getProductById(product_spu_id);
        if (productSpu != null) {
            model.addAttribute("productSpu",productSpu);
            return "query_spu_by_id";
        } else {
            return "query_spu_by_id";
        }
    }

    //Thymeleaf 練習RequestParam
    @GetMapping("/product_spu")
    public String getProductSpus(Model model,
            @RequestParam(required = false) String search ,
            @RequestParam(required = false) String brandId,
            @RequestParam(defaultValue = " product_spu.price") String orderBy,
            @RequestParam(defaultValue = " desc") String sort){
        ProductSpuQueryParam productSpuQueryParam = new ProductSpuQueryParam();
        productSpuQueryParam.setSearch(search);
        productSpuQueryParam.setBrandId(brandId);
        productSpuQueryParam.setOrderBy(orderBy);
        productSpuQueryParam.setSort(sort);
        List<ProductSpu> productSpuList=productSpuService.getProductSpuList(productSpuQueryParam);
        model.addAttribute("productSpuList",productSpuList);

        return "query_spu";
    }

    @GetMapping("/form")
    public String queryByFormInput(Model model) {
        ProductSpuQueryParam productSpuQueryParam = new ProductSpuQueryParam();
        model.addAttribute("productSpuQueryParam",productSpuQueryParam);

        return "query_form";
    }

    @GetMapping("/query")
    public String queryByForm(Model model,@ModelAttribute
                              ProductSpuQueryParam productSpuQueryParam) {
        List<ProductSpu> productSpuList = productSpuService.getProductSpuList(productSpuQueryParam);
        model.addAttribute("productSpuList", productSpuList);
        return "query_v3";
    }

    @GetMapping("form_query")
    public String queryByFormAndReturn(Model model) {
        ProductSpuQueryParam productSpuQueryParam = new ProductSpuQueryParam();
        model.addAttribute("productSpuQueryParam",productSpuQueryParam);

        return "query_v3";
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

    @DeleteMapping("/product_spu/{product_spu_id}")
    public ResponseEntity<?> deleteProductSpuById(@PathVariable Integer product_spu_id) {
        productSpuService.deleteProductSpuById(product_spu_id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
