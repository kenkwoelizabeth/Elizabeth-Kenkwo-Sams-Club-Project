package com.samsclub.item;


import com.samsclub.category.Category;
import com.samsclub.purchaseOrder.PurchaseOrder;
import com.samsclub.store.Store;
import com.samsclub.supplier.Supplier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    private String itemName;
    private String description;
    private double price;
    private long initialQuantity;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToMany(mappedBy = "item")
    private List<PurchaseOrder> purchaseOrder;

    // constructor


    public Item() {
    }

    public Item(String itemName, String description, double price, long initialQuantity, Store store, Category category, Supplier supplier, List<PurchaseOrder> purchaseOrder) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.initialQuantity = initialQuantity;
        this.store = store;
        this.category = category;
        this.supplier = supplier;
        this.purchaseOrder = purchaseOrder;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(long initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<PurchaseOrder> getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(List<PurchaseOrder> purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
