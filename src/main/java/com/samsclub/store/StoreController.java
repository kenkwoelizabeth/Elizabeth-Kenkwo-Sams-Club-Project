package com.samsclub.store;

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
public class StoreController {


    // injecting the dependency
    @Autowired
    private StoreService storeService;


    // car page
    @GetMapping("/store")
    public String getAllStores(Model model) {
        model.addAttribute("listCars", storeService.getAllStores());
        return "store/store_list";
    }

    @GetMapping("/my_stores")
    public String getMyStores(Model model) {
        // create model attribute to bind form data
        Store store = new Store();
        model.addAttribute("store", store);
        return "store/new_store";
    }

    @PostMapping("/saveStore")
    public String saveStore(@ModelAttribute("car") @Valid Store store,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "store/new_store";
        }

        // save store to database
        storeService.createStore(store);
        return "redirect:/store";
    }

    @GetMapping("/my_stores/{id}")
    public String getStoresById(@PathVariable(value = "id") long storeId, Model model) {

        // get store from the service
        Store store = storeService.getStoreById(storeId);

        // set store as a model attribute to pre-populate the form
        model.addAttribute("store", store);
        return "store/update_store";
    }

    @GetMapping("/deleteStore/{id}")
    public String deleteStore(@PathVariable(value = "id") long storeId) {

        // call delete store method
        this.storeService.deleteStore(storeId);
        return "redirect:/store";
    }
}
