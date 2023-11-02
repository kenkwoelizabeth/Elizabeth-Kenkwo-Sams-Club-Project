package com.samsclub.item;


import com.samsclub.Category.Category;
import org.apache.catalina.Store;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    private String itemName;
    private String description;
    private double price;
    private long initialQuantity;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    // constructor


    public Item() {
    }

    public Item(String itemName, String description, double price, long initialQuantity, Category category) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.initialQuantity = initialQuantity;
        this.category = category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
