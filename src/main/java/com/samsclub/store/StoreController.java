package com.samsclub.store;

import com.samsclub.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class StoreController {


    // injecting the dependency
    @Autowired
    private StoreService storeService;

    @GetMapping("/")
    public String home(Model model) {

        return "home";
    }


    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }


    @GetMapping("/cover")
    public String coverPage(Model model) {

        return "cover";
    }

    // car page
    @GetMapping("/store")
    public String getAllStores(Model model) {
        model.addAttribute("listStores", storeService.getAllStore());
        model.addAttribute("storeQueryObj", new StoreQueryObj());
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
    public String saveStore(@ModelAttribute("store") @Valid Store store,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "store/new_store";
        }

        // save store to database
        storeService.saveStore(store);
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


    // SEARCH CONTROLLER

    @PostMapping("/findStores")
    public String findStores(@ModelAttribute StoreQueryObj storeQueryObj, Model model) {
        System.out.println("qName is " + storeQueryObj.getQueryName());
        System.out.println("qName is " + storeQueryObj.getQueryType());
        System.out.println("qLocation is " + storeQueryObj.getQueryLocation());
        System.out.println("qDate is " + storeQueryObj.getQueryOpeningDate());

        Set<Store> storeSet = new HashSet<>();

        if(storeQueryObj.getQueryName().isEmpty()
                && storeQueryObj.getQueryLocation().isEmpty()
                && storeQueryObj.getQueryType().isEmpty()
                && storeQueryObj.getQueryOpeningDate()== null) {
            System.out.println("all empty fields");

            storeSet .addAll(storeService.getAllStore());
        } else {
            if (!storeQueryObj.getQueryName().isEmpty()) {
                String name = storeQueryObj.getQueryName();
                storeSet .addAll(storeService.findByStoreNameContaining(name));
            }

            if (!storeQueryObj.getQueryLocation().isEmpty()) {
                storeSet.addAll(storeService.findByStoreLocationContaining(storeQueryObj.getQueryLocation()));
            }

            if (!storeQueryObj.getQueryType().isEmpty()) {
                storeSet.addAll(storeService.findByStoreTypeContaining(storeQueryObj.getQueryLocation()));
            }

            if (storeQueryObj.getQueryOpeningDate() != null) {
                storeSet.addAll(storeService.findByOpeningDateEquals(storeQueryObj.getQueryOpeningDate()));
            }
        }

        model.addAttribute("listStores", storeSet);
        model.addAttribute("storeQueryObj", new StoreQueryObj());
        return "store/store_list";
    }
}


