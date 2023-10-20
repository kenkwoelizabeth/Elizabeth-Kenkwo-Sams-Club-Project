package com.samsclub.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StoreRestController {

    @Autowired
    private StoreService storeService;


    @GetMapping("stores")
    public Store createStore(@RequestBody Store store) {

        return storeService.createStore(store);
    }

    @GetMapping("my-stores")
    public List<Store> getStores() {

        return storeService.getAllStores();

    }

    @GetMapping("store/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable(value = "id") long storeId) {
        Store existingStore = storeService.getStoreById(storeId);

        return ResponseEntity.ok(existingStore);
    }

    @PutMapping("store/{id}")
    public String updateStore(@PathVariable("id") long storeId, @RequestBody Store store) {
        storeService.updateStore(storeId, store);
        return "redirect:/myStores";
    }

    @DeleteMapping("stores/{id}")
    public String deleteStore(@PathVariable("id") long storeId) {
        storeService.deleteStore(storeId);
        return "redirect:/stores";
    }


}