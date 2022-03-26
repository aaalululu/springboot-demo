package com.chianlulu.springbootdemo.controller;

import com.chianlulu.springbootdemo.dto.BrandRequest;
import com.chianlulu.springbootdemo.model.Brand;
import com.chianlulu.springbootdemo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brand/{brandId}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Integer brandId) {
        Brand brand = new Brand();
        brand=brandService.getBrandById(brandId);
        if(brand!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(brand);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/brand")
    public ResponseEntity<Brand> insertBrand(@RequestBody @Valid BrandRequest brandRequest) {
        Brand brand = new Brand();
        Integer brandId=brandService.insertBrand(brandRequest);
        brand=brandService.getBrandById(brandId);
        if(brand!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(brand);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/brand/{brandId}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Integer brandId,
                                             @RequestBody @Valid BrandRequest brandRequest) {


        if (brandService.getBrandById(brandId)==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            brandService.updateBrand(brandId,brandRequest);
            Brand brand = brandService.getBrandById(brandId);
            return ResponseEntity.status(HttpStatus.OK).body(brand);
        }
    }

    @DeleteMapping("/brand/{brandId}")
    public ResponseEntity<?> deleteBrand(@PathVariable Integer brandId) {
        brandService.deleteBrandById(brandId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
