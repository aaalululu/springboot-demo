package com.chianlulu.springbootdemo.controller;

import com.chianlulu.springbootdemo.dto.CategoryRequest;
import com.chianlulu.springbootdemo.model.Category;
import com.chianlulu.springbootdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer categoryId) {
        Category category= categoryService.getCategoryById(categoryId);
        if(category != null) {
            return ResponseEntity.status(HttpStatus.OK).body(category);
        } else {
            //4-14 查下build是什麼
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        Integer categoryId= categoryService.insertCategory(categoryRequest);
        Category category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    //接住url傳來category_id的值
    @PutMapping("/category/{categoryId}")
    public ResponseEntity<Category> updateCategory(@RequestBody @Valid CategoryRequest categoryRequest,
                                                   @PathVariable Integer categoryId) {

        if( categoryService.getCategoryById(categoryId)==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        } else {
            categoryService.updateCategory(categoryId,categoryRequest);
            Category category = categoryService.getCategoryById(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(category);
        }


    }
}
