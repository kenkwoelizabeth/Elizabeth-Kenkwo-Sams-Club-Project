package com.samsclub.pages;

import com.samsclub.store.Store;
import com.samsclub.store.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private StoreRepo storeRepo;

    @GetMapping("/home")
    public String homePage(Model model) {
        List<Store> stores = storeRepo.findAll();
        model.addAttribute("stores", stores);
        return "home";
    }
}
