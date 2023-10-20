package com.samsclub.store;

import java.util.List;

public interface StoreService {
    // defining the functionality provided by the service
    public Store createStore(Store store);

    public List<Store> getAllStores();

    public Store updateStore(long storeId, Store store);

    public Store getStoreById(long storeId);

    public void deleteStore(long storeId);

    public List<Store> getStoreByName(String storeName);
}
