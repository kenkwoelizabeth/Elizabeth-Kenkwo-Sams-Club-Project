package com.samsclub.Category;

import com.samsclub.item.Item;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CategoryService {
    public Category saveCategory(Category category);

    public List<Category> getAllCategory();
    public Category getCategoryById(long categoryId);
    public Category updateCategory(long categoryId, Category category);



    public void deleteCategory(long categoryId);
}
