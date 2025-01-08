package com.scaler.practiceproject.Controller;

import com.scaler.practiceproject.Models.Category;
import com.scaler.practiceproject.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @PostMapping("/Category")
    public Category Createcategory(@RequestBody Category category) {
        Category C = categoryService.CreateCategory(category.getId(),category.getName());
        return C;
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        Category c = categoryService.GetCategoryById(id);
        ResponseEntity<Category> responce = new ResponseEntity<>(c, HttpStatus.OK);
        return responce;
    }
}
