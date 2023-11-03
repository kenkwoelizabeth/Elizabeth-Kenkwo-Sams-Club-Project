package com.samsclub.purchaseOrder;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseOrderService {
    // defining the functionality provided by the service
    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder);

    public List<PurchaseOrder> getAllPurchaseOrder();
    public PurchaseOrder getPurchaseOrderById(long purchaseId);
    public PurchaseOrder updatePurchaseOrder(long purchaseId, PurchaseOrder purchaseOrder);

    public void deletePurchaseOrder(long purchaseId);



}
