package com.samsclub.item;


import com.samsclub.category.Category;
import com.samsclub.store.Store;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ItemService {
    // defining the functionality provided by the service
    public Item saveItem(Item item);

    public List<Item> getAllItem();

    public Item getItemById(Long itemId);

    public Item updateItem(Long itemId, Item item);

    public void deleteItem(Long itemId);


    List<Item> findByItemNameContaining(String ItemNameInfix);
    List<Item> findByPriceBetween(Double minPrice, Double maxPrice);
    public List<Item> findByCategory(Category category);

}
