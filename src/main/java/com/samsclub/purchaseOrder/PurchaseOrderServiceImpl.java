package com.samsclub.purchaseOrder;



import com.samsclub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepo purchaseOrderRepo;

    @Override
    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepo.save(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrder() {
        return purchaseOrderRepo.findAll();
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(long purchaseId) {
        return purchaseOrderRepo.findById(purchaseId)
                .orElseThrow(() -> new ResourceNotFoundException("PurchaseOrder does not exist with the ID: " + purchaseId));
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(long purchaseId, PurchaseOrder purchaseOrder) {

        PurchaseOrder existingPurchaseOrder =purchaseOrderRepo.findById(purchaseId)
                .orElseThrow(() -> new ResourceNotFoundException("Item does not exist with the ID: " + purchaseId));

        existingPurchaseOrder.setQuantity(purchaseOrder.getQuantity());
        existingPurchaseOrder.setStatus(purchaseOrder.getStatus());
        return purchaseOrderRepo.save(existingPurchaseOrder);
    }

    @Override
    public void deletePurchaseOrder(long purchaseId) {
        PurchaseOrder existingPurchaseOrder =purchaseOrderRepo.findById(purchaseId)
                .orElseThrow(() -> new ResourceNotFoundException("PurchaseOrder does not exist with the ID: " + purchaseId));
        purchaseOrderRepo.delete(existingPurchaseOrder);
    }


}

