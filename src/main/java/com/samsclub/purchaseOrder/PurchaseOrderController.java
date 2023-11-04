package com.samsclub.purchaseOrder;


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
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;


    @GetMapping("/purchaseOrder")
    public String getAllPurchaseOrders(Model model) {
        model.addAttribute("listPurchaseOrders", purchaseOrderService.getAllPurchaseOrder());
        return "purchaseOrder/purchaseOrder_list";
    }

    @GetMapping("/my_purchaseOrders")
    public String getMyPurchaseOrders(Model model) {
        // create model attribute to bind form data
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        model.addAttribute("purchaseOrder", purchaseOrder);
        return "purchaseOrder/new_purchaseOrder";
    }

    @PostMapping("/savePurchaseOrder")
    public String savePurchaseOrder(@ModelAttribute("purchaseOrder") @Valid PurchaseOrder purchaseOrder,
                                    BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "purchaseOrder/new_purchaseOrder";
        }

        // save store to database
        purchaseOrderService.savePurchaseOrder(purchaseOrder);
        return "redirect:/purchaseOrder";
    }

    @GetMapping("/my_purchaseOrders/{id}")
    public String getPurchaseOrdersById(@PathVariable(value = "id") long purchaseId, Model model) {

        // get store from the service
        PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrderById(purchaseId);

        // set store as a model attribute to pre-populate the form
        model.addAttribute("purchaseOrder", purchaseOrder);
        return "purchaseOrder/update_purchaseOrder";
    }

    @GetMapping("/deletePurchaseOrder/{id}")
    public String deletePurchaseOrder(@PathVariable(value = "id") long purchaseId) {

        // call delete store method
        this.purchaseOrderService.deletePurchaseOrder(purchaseId);
        return "redirect:/purchaseOrder";

    }
}
