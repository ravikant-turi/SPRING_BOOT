package com.blog.Blog_app_api.controller;


import com.blog.Blog_app_api.exception.ApiResponse;
import com.blog.Blog_app_api.dto.CategoryDto;
import com.blog.Blog_app_api.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
         CategoryDto categoryDto1=this.categoryService.createCategory(categoryDto);
        return new   ResponseEntity<>( categoryDto1, HttpStatus.CREATED);
    }


    @PutMapping("/{catId}")
    public  ResponseEntity<CategoryDto>updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
        CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto,catId);
        return  new ResponseEntity<>(updatedCategory,HttpStatus.CREATED);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto>getCategoryById(@Valid @RequestBody @PathVariable Integer catId){

       CategoryDto categoryDto=  this.categoryService.getCategory(catId);
       return new  ResponseEntity<>(categoryDto,HttpStatus.OK);
    }
    @GetMapping("/")
    public  ResponseEntity<List<CategoryDto>> getAllCategory(){

        List<CategoryDto>list=this.categoryService.getAllCategory();

        return new ResponseEntity<>(list,HttpStatus.OK);

    }
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId") Integer catID){

       this.categoryService.deleteCategory(catID);
        return  new ResponseEntity<>(new ApiResponse("category deleted",true),HttpStatus.OK);

    }
}
