package com.samsclub.purchaseOrder;


import com.samsclub.item.Item;
import com.samsclub.supplier.Supplier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

@Entity
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long purchaseId;


    private int quantity;


    private String status;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Item_PurchaseOrder",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "purchase_id") }
    )
   private List<Item> item;

    // constructor


    public PurchaseOrder() {
    }

    public PurchaseOrder(int quantity, String status, Supplier supplier, List<Item> item) {
        this.quantity = quantity;
        this.status = status;
        this.supplier = supplier;
        this.item = item;
    }

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
