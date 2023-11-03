package com.samsclub.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String getAllCategories(Model model) {
        model.addAttribute("listCategories", categoryService.getAllCategory());
        return "category/category_list";
    }

    @GetMapping("/my_categories")
    public String getMyCategories(Model model) {
        // create model attribute to bind form data
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/new_category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") @Valid Category category,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "category/new_category";
        }

        // save store to database
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/my_categories/{id}")
    public String getCategoriesById(@PathVariable(value = "id") long categoryId, Model model) {

        // get store from the service
        Category category = categoryService.getCategoryById(categoryId);

        // set store as a model attribute to pre-populate the form
        model.addAttribute("category", category);
        return "category/update_category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable(value = "id") long categoryId) {

        // call delete store method
        this.categoryService.deleteCategory(categoryId);
        return "redirect:/category";
    }
}
