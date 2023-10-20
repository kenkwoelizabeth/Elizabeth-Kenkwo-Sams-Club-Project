package com.samsclub.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {
    List<Store> findByStoreName(String storeName);

// providing additional functionality to the store crud method

}
