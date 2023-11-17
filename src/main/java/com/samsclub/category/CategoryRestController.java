package com.samsclub.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public Category saveCategory(@RequestBody Category category) {

        return categoryService.saveCategory(category);
    }

    @GetMapping("/my_categories")
    public List<Category> getCategories() {

        return categoryService.getAllCategory();

    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long categoryId) {
        Category existingCategory = categoryService.getCategoryById(categoryId);

        return ResponseEntity.ok(existingCategory);
    }

    @PutMapping("/category/{id}")
    public String updateCategory(@PathVariable("id") Long categoryId, @RequestBody Category category) {
        categoryService.updateCategory(categoryId, category);
        return "redirect:/myCategories";
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/categories";
    }
}
