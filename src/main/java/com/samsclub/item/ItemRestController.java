package com.samsclub.item;


import com.samsclub.store.Store;
import com.samsclub.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemRestController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public Item createItem(@RequestBody Item item) {

        return itemService.saveItem(item)
    }

    @GetMapping("/my_items")
    public List<Item> getItems() {

        return itemService.getAllItem();

    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") long itemId) {
        Item existingItem = itemService.getItemById(itemId);

        return ResponseEntity.ok(existingItem);
    }

    @PutMapping("/item/{id}")
    public String updateItem(@PathVariable("id") long itemId, @RequestBody Item item) {
        itemService.updateItem(itemId, item);
        return "redirect:/myItems";
    }

    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable("id") long itemId) {
        itemService.deleteItem(itemId);
        return "redirect:/items";
    }


}
