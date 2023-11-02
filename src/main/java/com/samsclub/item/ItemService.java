package com.samsclub.item;


import com.samsclub.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    // defining the functionality provided by the service
    public Item saveItem(Item item);

    public List<Item> getAllItem();
    public Item getItemById(long itemId);
    public Item updateItem(long itemId, Item item);



    public void deleteItem(long itemId);


}
