package com.samsclub.item;



import com.samsclub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Item saveItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public List<Item> getAllItem() {
        return itemRepo.findAll();
    }

    @Override
    public Item getItemById(long itemId) {
        return itemRepo.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item does not exist with the ID: " + itemId));
    }

    @Override
    public Item updateItem(long itemId, Item item) {

        Item existingItem =itemRepo.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item does not exist with the ID: " + itemId));
        existingItem.setItemName(item.getItemName());
        existingItem.setDescription(item.getDescription());
        existingItem.setPrice(item.getPrice());
        existingItem.setInitialQuantity(item.getInitialQuantity());

        return itemRepo.save(existingItem);
    }

    @Override
    public void deleteItem(long itemId) {
        Item existingItem =itemRepo.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item does not exist with the ID: " + itemId));
        itemRepo.delete(existingItem);
    }


}

