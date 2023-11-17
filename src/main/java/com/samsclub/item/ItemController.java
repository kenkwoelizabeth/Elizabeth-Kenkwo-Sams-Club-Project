package com.samsclub.item;


import com.samsclub.category.CategoryService;
import com.samsclub.store.Store;
import com.samsclub.store.StoreQueryObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/item")
    public String getAllItems(Model model) {

        model.addAttribute("listItems", itemService.getAllItem());
        model.addAttribute("listCategories", categoryService.getAllCategory());
        model.addAttribute("itemQueryObj", new ItemQueryObj());
        return "item/item_list";
    }

    @GetMapping("/my_items")
    public String getMyItems(Model model) {
        // create model attribute to bind form data
        Item item = new Item();
        model.addAttribute("item", item);
        return "item/new_item";
    }

    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute("item") @Valid Item item,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "item/new_item";
        }

        // save store to database
        itemService.saveItem(item);
        return "redirect:/item";
    }

    @GetMapping("/my_items/{id}")
    public String getItemsById(@PathVariable(value = "id") long itemId, Model model) {

        // get store from the service
        Item item = itemService.getItemById(itemId);

        // set store as a model attribute to pre-populate the form
        model.addAttribute("item", item);
        return "item/update_item";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable(value = "id") long itemId) {

        // call delete store method
        this.itemService.deleteItem(itemId);
        return "redirect:/item";
    }

    @PostMapping("/findItems")
    public String findItems(@ModelAttribute ItemQueryObj itemQueryObj, Model model) {
        System.out.println("qName is " + itemQueryObj.getQueryName());
        System.out.println("qCategory is " + itemQueryObj.getQueryCategory());
        System.out.println("minPrice is " + itemQueryObj.getMinPrice());
        System.out.println("maxPrice is " + itemQueryObj.getMaxPrice());

        Set<Item> itemSet = new HashSet<>();

        if (itemQueryObj.getQueryName().isEmpty()
                && itemQueryObj.getQueryCategory() == null
                && itemQueryObj.getMinPrice() == null
                && itemQueryObj.getMaxPrice() == null) {
            System.out.println("all empty fields");

            itemSet.addAll(itemService.getAllItem());
        } else {
            if (!itemQueryObj.getQueryName().isEmpty()) {
                String name = itemQueryObj.getQueryName();
                itemSet.addAll(itemService.findByItemNameContaining(name));
            }

            if (itemQueryObj.getQueryCategory() != null) {
                itemSet.addAll(itemService.findByCategory(itemQueryObj.getQueryCategory()));
            }

            if (itemQueryObj.getMinPrice() != null && itemQueryObj.getMaxPrice() != null) {
                itemSet.addAll(itemService.findByPriceBetween(itemQueryObj.getMinPrice(), itemQueryObj.getMaxPrice()));
            }
        }

        model.addAttribute("listItems", itemSet);
        model.addAttribute("itemQueryObj", new ItemQueryObj());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "item/item_list";
    }


}
