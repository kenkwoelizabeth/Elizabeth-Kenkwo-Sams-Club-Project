package com.samsclub.repositories;


import com.samsclub.item.Item;
import com.samsclub.store.Store;
import com.samsclub.item.ItemRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

@SpringBootTest
@DataJpaTest
@Transactional
public class ItemRepoTest2 {
    @Autowired
    private ItemRepo itemRepo;

    @Test
    public void testSaveItem() {
        // Create a new item
        Item item = new Item();
        item.setItemName("Bread");
        item.setDescription("Sweet Bread");
        item.setPrice(50.4);
        item.setInitialQuantity(20);
        item.setStore(new Store());

        // Save the item to the repository
        itemRepo.save(item);

        // Retrieve the item from the repository
        Item savedItem = itemRepo.findById(item.getItemId()).orElse(null);

        // Assert that the saved item is not null
        Assert.notNull(savedItem, "Saved item should not be null");

        // Assert that the saved item's properties match the expected values
        Assert.isTrue("Bread".equals(savedItem.getItemName()), "Item name should be 'Bread'");
        Assert.isTrue("Sweet Bread".equals(savedItem.getDescription()), "Description should be 'Sweet Bread'");
        Assert.isTrue(50.4 == savedItem.getPrice(), "Price should be 50.4");
        Assert.isTrue(20 == savedItem.getInitialQuantity(), "Initial quantity should be 20");
    }
}