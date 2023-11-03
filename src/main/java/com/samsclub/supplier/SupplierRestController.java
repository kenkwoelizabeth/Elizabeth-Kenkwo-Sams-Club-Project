package com.samsclub.supplier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierRestController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/supplier")
    public Supplier saveSupplier(@RequestBody Supplier supplier) {

        return supplierService.saveSupplier(supplier);
    }

    @GetMapping("/my_suppliers")
    public List<Supplier> getSupplier() {

        return supplierService.getAllSupplier();
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "id") long supplierId) {
        Supplier existingSupplier =supplierService.getSupplierById(supplierId);

        return ResponseEntity.ok(existingSupplier);
    }

    @PutMapping("/supplier/{id}")
    public String updateSupplier(@PathVariable("id") long supplierId, @RequestBody Supplier supplier) {
      supplierService.updateSupplier(supplierId,supplier);
        return "redirect:/mySupplier";
    }

    @DeleteMapping("/suppliers/{id}")
    public String deleteSupplier(@PathVariable("id") long supplierId) {
       supplierService.deleteSupplier(supplierId);
        return "redirect:/suppliers";
    }



}
