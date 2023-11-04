package com.samsclub.supplier;

import com.samsclub.item.Item;
import com.samsclub.purchaseOrder.PurchaseOrder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    // fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierId;
    private String name;
    private String location;
    private String phoneNumber;

    @OneToMany(mappedBy = "supplier")
    private List<Item> item;

    @OneToMany(mappedBy = "supplier")
    private List<PurchaseOrder> purchaseOrder;
    //constructors

    public Supplier() {
    }

    public Supplier(String name, String location, String phoneNumber, List<Item> item, List<PurchaseOrder> purchaseOrder) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.item = item;
        this.purchaseOrder = purchaseOrder;
    }

    //getters and setters


    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public List<PurchaseOrder> getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(List<PurchaseOrder> purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
