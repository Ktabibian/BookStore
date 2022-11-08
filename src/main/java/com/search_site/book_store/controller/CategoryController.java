package com.search_site.book_store.controller;

import com.search_site.book_store.model.Category;
import com.search_site.book_store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> getAllCategories(Category category){
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        return categoryService.updateCategory(category, categoryId);
    }


    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}
