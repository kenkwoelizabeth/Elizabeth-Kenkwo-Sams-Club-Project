package com.samsclub.item;

import com.samsclub.category.Category;

public class ItemQueryObj {
    private String queryName = "";
    private Category queryCategory;;
    private Double minPrice;
    private Double maxPrice;

    public ItemQueryObj() {
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public Category getQueryCategory() {
        return queryCategory;
    }

    public void setQueryCategory(Category queryCategory) {
        this.queryCategory = queryCategory;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }
}