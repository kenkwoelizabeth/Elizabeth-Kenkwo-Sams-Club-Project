package com.samsclub.item;




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
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/item")
    public String getAllItems(Model model) {
        model.addAttribute("listItems", itemService.getAllItem());
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
}
