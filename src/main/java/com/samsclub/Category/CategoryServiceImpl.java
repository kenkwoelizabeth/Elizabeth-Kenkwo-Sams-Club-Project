package com.samsclub.Category;



import com.samsclub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(long categoryId) {
        return categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category does not exist with the ID: " + categoryId));
    }

    @Override
    public Category updateCategory(long categoryId, Category category) {

        Category existingCategory =categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category does not exist with the ID: " + categoryId));
        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setItem(category.getItem());

        return categoryRepo.save(existingCategory);
    }

    @Override
    public void deleteCategory(long categoryId) {
        Category existingCategory =categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category does not exist with the ID: " + categoryId));
        categoryRepo.delete(existingCategory);
    }
}
