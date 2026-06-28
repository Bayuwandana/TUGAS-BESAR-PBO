package com.tup.temp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.tup.temp.entity.Category;
import com.tup.temp.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }
}