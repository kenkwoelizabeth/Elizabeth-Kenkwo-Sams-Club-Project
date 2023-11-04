package com.samsclub.services;



import com.samsclub.exception.ResourceNotFoundException;
import com.samsclub.item.Item;
import com.samsclub.item.ItemService;
import com.samsclub.store.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

// Using @SpringBootTest to create application context
@SpringBootTest
class ItemServiceImplTest {

    @Autowired
    private ItemService itemService;

    @BeforeEach
    void setUp() {


        Item item = new Item();
        item.setItemName("Bread");
        item.setDescription("Sweet Bread");
        item.setPrice(50.4);
        item.setInitialQuantity(20);


        Item item1 = new Item("Bread", "Wheat", 40, 5, new Store());
        itemService.saveItem(item1);

    }

    @Test
    void getAllItems_should_return_all_items() {

        List<Item> allItems = itemService.getAllItem();
        int beforeAddingMoreItems = allItems.size();

        Item itemSaved= new Item("Bread", "Wheat", 40, 5, new Store());
        itemService.saveItem(itemSaved);
        int afterAddingMoreItems = itemService.getAllItem().size();

        Assertions.assertThat(afterAddingMoreItems).isEqualTo(beforeAddingMoreItems + 1);
    }

    @Test
    void saveItem_with_valid_data_should_save_it_successfully() {
        double random = Math.random();
        String randomItemName = "Bread" + random;
        String randomItemDescription = "Wheat" + random;
        Item item = new Item(randomItemName, "Wheat", 40, 5, new Store());

        itemService.saveItem(item);

        List<Item> allItems = itemService.getAllItem();
        Assertions.assertThat(allItems.contains(item));
    }

    @Test
    void getCarById_with_valid_id_should_return_valid_car() {
        List<Item> allItems = itemService.getAllItem();
        Item item1 = allItems.get(0);
        if (item1 != null) {
            Item item2 = itemService.getItemById(item1.getItemId());
            Assertions.assertThat(item1).isEqualTo(item2);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
        // six numbers
    void getItemById_with_parameterized_data(long itemId) {
        Item item = itemService.getItemById(itemId);
        Assertions.assertThat(item.getItemId()).isEqualTo(itemId);
    }

    @Test
    void _getItemById_with_invalid_id_should_throw_ItemNotFoundException() {
        List<Item> allItems = itemService.getAllItem();
        int invalidItemId = allItems.size() + 10;

        // Using JUnit 5 assertion package
        org.junit.jupiter.api.Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> {
                    itemService.getItemById(invalidItemId);
                });

        // Using AssertJ assertion package
        Assertions.assertThatThrownBy(() -> {
            itemService.getItemById(invalidItemId);
        }).isInstanceOf(ResourceNotFoundException.class);
    }
}