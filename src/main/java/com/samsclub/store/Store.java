package com.samsclub.store;

import com.samsclub.item.Item;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
public class Store {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeId;
    private String storeName;
    private String storeLocation;
    private String storeType;
    private LocalDate openingDate;

    @OneToMany(mappedBy="store")
    private List<Item> item;



    // constructors


    public Store() {
    }

    public Store(String storeName, String storeLocation, String storeType, LocalDate openingDate) {
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storeType = storeType;
        this.openingDate = openingDate;
    }

    //getters and setters

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
