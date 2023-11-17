package com.samsclub.category;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CategoryService {
    public Category saveCategory(Category category);

    public List<Category> getAllCategory();

    public Category getCategoryById(Long categoryId);

    public Category updateCategory(Long categoryId, Category category);


    public void deleteCategory(Long categoryId);
}
