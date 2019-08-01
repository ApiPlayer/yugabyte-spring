package com.yugabyte.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yugabyte.springdemo.model.ShoppingList;
import com.yugabyte.springdemo.model.Item;

import java.util.UUID;

public interface ShoppingListRepository {
    public ShoppingList saveList(ShoppingList shoppingList);

    public ShoppingList findList(UUID listId);

    public ShoppingList addItem(UUID listId, Item item);

//    public ShoppingList incQuantity(UUID listId, String itemId);
//
//    public ShoppingList decQuantity(UUID listId, String itemId);

    public ShoppingList deleteList(UUID listId);

    public ShoppingList updateQuantity(UUID listId, UUID itemId, int newQuantity);

    public ShoppingList deleteItem(UUID listId, UUID itemId);
}
