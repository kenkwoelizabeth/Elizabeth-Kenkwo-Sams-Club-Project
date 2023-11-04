package com.samsclub.supplier;

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
public class SupplierController {
    @Autowired
    private SupplierService supplierService;


    @GetMapping("/supplier")
    public String getAllSupplier(Model model) {
        model.addAttribute("listSuppliers", supplierService.getAllSupplier());
        return "supplier/supplier_list";
    }


    @GetMapping("/my_suppliers")
    public String getMySuppliers(Model model) {
        // create model attribute to bind form data
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "supplier/new_supplier";
    }

    @PostMapping("/saveSupplier")
    public String saveSupplier(@ModelAttribute("supplier") @Valid Supplier supplier,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "supplier/new_supplier";
        }
        // save menu to database
        supplierService.saveSupplier(supplier);
        return "redirect:/supplier";
    }

    @GetMapping("/my_suppliers/{id}")
    public String getSuppliersById(@PathVariable(value = "id") long supplierId, Model model) {

        Supplier supplier = supplierService.getSupplierById(supplierId);
        model.addAttribute("supplier", supplier);

        return "supplier/update_supplier";
    }

    @GetMapping("/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable(value = "id") long supplierId) {
        this.supplierService.deleteSupplier(supplierId);

        return "redirect:/supplier";
    }
}
