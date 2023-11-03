package com.samsclub.item;



import com.samsclub.store.Store;

import javax.persistence.*;
import java.io.Serializable;

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
@JoinColumn(name="store_id")
private Store store;

    // constructor


    public Item() {
    }

    public Item(String itemName, String description, double price, long initialQuantity, Store store) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.initialQuantity = initialQuantity;
        this.store = store;
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
}
