package com.search_site.book_store.service;

import com.search_site.book_store.model.Category;
import com.search_site.book_store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public ResponseEntity<Iterable<Category>> getAllCategories() {
        Iterable<Category> allCategories = categoryRepository.findAll();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    public ResponseEntity<?> getCategory(Long categoryId) {
        Category c = categoryRepository.findById(categoryId).orElse(null);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    public ResponseEntity<?> updateCategory(Category category, Long categoryId) {
        Category c = categoryRepository.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
