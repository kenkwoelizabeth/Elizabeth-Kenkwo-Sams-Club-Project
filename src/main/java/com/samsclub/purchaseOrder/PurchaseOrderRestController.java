package com.samsclub.purchaseOrder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PurchaseOrderRestController {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping("/purchaseOrders")
    public PurchaseOrder savePurchaseOrder (@RequestBody PurchaseOrder purchaseOrder) {

        return purchaseOrderService.savePurchaseOrder(purchaseOrder);
    }

    @GetMapping("/my_purchaseOrders")
    public List<PurchaseOrder> getPurchaseOrders() {

        return purchaseOrderService.getAllPurchaseOrder();

    }

    @GetMapping("/purchaseOrder/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable(value = "id") long purchaseId) {
        PurchaseOrder existingPurchaseOrder = purchaseOrderService.getPurchaseOrderById(purchaseId);

        return ResponseEntity.ok(existingPurchaseOrder);
    }

    @PutMapping("/purchaseOrder/{id}")
    public String updatePurchaseOrder(@PathVariable("id") long purchaseId, @RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrderService.updatePurchaseOrder(purchaseId, purchaseOrder);
        return "redirect:/myPurchaseOrders";
    }

    @DeleteMapping("/purchaseOrders/{id}")
    public String deletePurchaseOrder(@PathVariable("id") long purchaseId) {
        purchaseOrderService.deletePurchaseOrder(purchaseId);
        return "redirect:/purchaseOrders";
    }


}
