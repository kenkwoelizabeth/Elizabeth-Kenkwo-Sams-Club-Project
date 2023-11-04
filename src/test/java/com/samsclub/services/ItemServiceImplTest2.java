package com.samsclub.services;


import com.samsclub.SamsClubProjectApplication;
import com.samsclub.item.Item;
import com.samsclub.item.ItemService;
import com.samsclub.store.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

// We are not using @SpringBootTest, so we have to
// manually run the application in order to
// create application context
class ItemServiceImplTest2 {

    private static ItemService itemService;

    @BeforeAll
    static void beforeAll() {
        ConfigurableApplicationContext applicationContext
                = SpringApplication.run(SamsClubProjectApplication.class);
        itemService = applicationContext.getBean(ItemService.class);
    }

    @BeforeEach
    void setUp() {


        Item item = new Item();
        item.setItemName("Bread");
        item.setDescription("Sweet Bread");
        item.setPrice(50.4);
        item.setInitialQuantity(20);
        item.setStore(new Store());
        itemService.saveItem(item);
    }

    @Test
    void getAllItems_should_return_all_cars() {

        List<Item> allItems = itemService.getAllItem();
        int beforeAddingMoreItems = allItems.size();

        Item item2 = new Item();

        item2.setItemName("Banana");
        item2.setDescription("Ripe");
        item2.setPrice(5);
        item2.setInitialQuantity(202);
        item2.setStore(new Store());
        itemService.saveItem(item2);
        int afterAddingMoreItems = itemService.getAllItem().size();

        Assertions.assertThat(afterAddingMoreItems).isEqualTo(beforeAddingMoreItems + 1);
    }

    @Test
    void saveItem_with_valid_data_should_save_it_successfully() {
        double random = Math.random();

        String randomItemName = "Banana" + random;
        String randomItemDescription = "Ripe" + random;
        Item item = new Item(randomItemName, randomItemDescription ,57, 22,new Store());

        itemService.saveItem(item);


        List<Item> allItems = itemService.getAllItem();
        Assertions.assertThat(allItems.contains(item));
    }

    @Test
    void getItemById_with_valid_id_should_return_valid_car() {
        List<Item> allCars = itemService.getAllItem();
        Item item1 = allCars.get(0);
        if (item1 != null) {
            Item item2 = itemService.getItemById(item1.getItemId());
            Assertions.assertThat(item1).isEqualTo(item2);
        }
    }
}