package com.samsclub.store;

import com.samsclub.item.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {
    // defining the functionality provided by the service
    public Store saveStore(Store store);

    public List<Store> getAllStore();

    public Store getStoreById(long storeId);

    public Store updateStore(long storeId, Store store);

    public void deleteStore(long storeId);

}
