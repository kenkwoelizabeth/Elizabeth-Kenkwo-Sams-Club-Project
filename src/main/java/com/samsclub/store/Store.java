package com.samsclub.store;


import com.samsclub.item.Item;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeId;
    private String storeName;
    private String storeLocation;
    private String storeContact;
    private String storeType;
    @OneToMany(mappedBy = "store")
    private List<Item> item;


    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date openingDate;


    // constructors


    public Store() {
    }

    public Store(String storeName, String storeLocation, String storeContact, String storeType, List<Item> item, Date openingDate) {
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storeContact = storeContact;
        this.storeType = storeType;
        this.item = item;
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

    public String getStoreContact() {
        return storeContact;
    }

    public void setStoreContact(String storeContact) {
        this.storeContact = storeContact;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }


}
