package com.samsclub.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {
    public List<Store> findByStoreNameContaining(String storeNameInfix);
    public List<Store> findByOpeningDateEquals(Date openingDate);
    public List<Store> findByStoreTypeContaining(String storeTypeInfix);
    public List<Store> findByStoreLocationContaining(String storeLocationInfix);

}
