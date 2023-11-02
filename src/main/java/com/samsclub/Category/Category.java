package com.samsclub.Category;

import com.samsclub.item.Item;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;
    private String categoryName;

    @OneToMany(targetEntity = Item.class,
    fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Item> item;

    public Category() {
    }

    public Category(String categoryName, List<Item> item) {
        this.categoryName = categoryName;
        this.item = item;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
