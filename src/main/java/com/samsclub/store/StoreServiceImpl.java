package com.samsclub.store;

import com.samsclub.exception.StoreNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StoreServiceImpl implements StoreService {


    @Autowired
    private StoreRepo storeRepo;



    @Override
    public Store createStore(Store store) {
       return storeRepo.save(store);
    }

    @Override
    public Store getStoreById(long storeId) {
        return storeRepo.findById(storeId)
                .orElseThrow(() -> new StoreNotFoundException("Store does " +
                        "not exist with the ID: " + storeId));

    }
    @Override
    public List<Store> getAllStores() {
        return storeRepo.findAll();
    }



    @Override
    public Store updateStore(long storeId, Store store) {

        Store existingStore = storeRepo.findById(storeId)
                .orElseThrow(() -> new StoreNotFoundException("Store does not exist with the ID: " + storeId));

        existingStore.setStoreName(store.getStoreName());
        existingStore.setStoreType(store.getStoreType());
        existingStore.setStoreLocation(store.getStoreLocation());
        existingStore.setOpeningDate(store.getOpeningDate());

        return storeRepo.save(existingStore);
    }



    @Override
    public void deleteStore(long storeId) {


        Store existingStore = storeRepo.findById(storeId)
                    .orElseThrow(() -> new StoreNotFoundException("Store does not exist with the ID: " + storeId));

        storeRepo.delete(existingStore);
        }

    @Override
    public List<Store> getStoreByName(String storeName) {

        return storeRepo.findByStoreName(storeName);
    }

}