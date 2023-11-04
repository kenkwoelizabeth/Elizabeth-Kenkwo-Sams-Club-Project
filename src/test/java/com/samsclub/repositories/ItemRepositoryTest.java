package com.samsclub.repositories;


import com.samsclub.item.Item;
import com.samsclub.item.ItemRepo;
import com.samsclub.store.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepo itemRepo;

    @BeforeEach
    void setUp() {


        Item item = new Item();
        item.setItemName("Bread");
        item.setDescription("Sweet Bread");
        item.setPrice(50.4);
        item.setInitialQuantity(20);
        item.setStore(new Store());

        itemRepo.save(item);
    }

    @Test
    void findFirstByItemName_should_return_Item_given_valid_name() {

        Item item = itemRepo.findByItemName("Bread");
        Assertions.assertThat(item.getItemName()).isEqualTo("Bread");
    }
}