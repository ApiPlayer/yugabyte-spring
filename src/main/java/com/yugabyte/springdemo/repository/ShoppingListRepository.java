package com.yugabyte.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yugabyte.springdemo.model.ShoppingList;
import com.yugabyte.springdemo.model.Item;

public interface ShoppingListRepository {
    public ShoppingList saveList(ShoppingList shoppingList);

    public ShoppingList findList(String listId);

    public ShoppingList addItem(String listId, Item item);

    public ShoppingList incQuantity(String listId, String itemId);

    public ShoppingList decQuantity(String listId, String itemId);

    public ShoppingList deleteList(String listId);

    public ShoppingList updateQuantity(String listId, String itemId, int newQuantity);

    public ShoppingList deleteItem(String listId, String itemId);
}
