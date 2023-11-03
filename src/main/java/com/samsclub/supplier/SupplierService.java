package com.samsclub.supplier;


import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SupplierService {
    public Supplier saveSupplier(Supplier supplier);

    public List<Supplier> getAllSupplier();


    public Supplier getSupplierById(long supplierId);

    public Supplier updateSupplier(long supplierId, Supplier supplier);

    public void deleteSupplier(long supplierId);
}

