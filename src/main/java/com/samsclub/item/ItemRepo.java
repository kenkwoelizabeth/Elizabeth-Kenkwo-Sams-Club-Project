package com.samsclub.item;


import com.samsclub.category.Category;
import com.samsclub.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {


    List<Item> findByItemNameContaining(String ItemNameInfix);

    List<Item> findByCategory(Category category);
    List<Item> findByPriceBetween(Double minPrice, Double maxPrice);
}
