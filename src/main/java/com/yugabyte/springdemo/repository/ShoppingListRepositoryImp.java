package com.yugabyte.springdemo.repository;

import com.yugabyte.springdemo.model.ShoppingList;
import com.yugabyte.springdemo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class ShoppingListRepositoryImp implements ShoppingListRepository
{
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public ShoppingList saveList(ShoppingList shoppingList)
    {
        entityManager.persist(shoppingList);
        return shoppingList;
    }

    @Override
    @Transactional
    public ShoppingList findList(String listId) {
        return entityManager.find(ShoppingList.class, listId);
    }

    @Override
    @Transactional
    public ShoppingList addItem(String listId, Item item) {
        ShoppingList curList = findList(listId);
        curList.getItems().add(item);
        return curList;
    }

    @Override
    @Transactional
    public ShoppingList incQuantity(String listId, String itemId) {
        ShoppingList list = findList(listId);
        for (Item item: list.getItems()) {
            if (item.getItemId().equals(itemId)) {
                item.incQuantity();
            }
        }
        return list;
    }

    @Override
    @Transactional
    public ShoppingList decQuantity(String listId, String itemId) {
        ShoppingList list = findList(listId);
        for (Item item: list.getItems()) {
            if (item.getItemId().equals(itemId)) {
                item.decQuantity();
            }
        }
        return list;
    }

    @Override
    @Transactional
    public ShoppingList updateQuantity(String listId, String itemId, int newQuantity) {
        ShoppingList list = findList(listId);
        for (Item item: list.getItems()) {
            if (item.getItemId().equals(itemId)) {
                item.setQuantity(newQuantity);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public ShoppingList deleteList(String listId) {
        ShoppingList list = findList(listId);
        entityManager.remove(list);
        return list;
    }

    @Override
    @Transactional
    public ShoppingList deleteItem(String listId, String itemId) {
        ShoppingList list = findList(listId);
        List<Item> items = list.getItems();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemId().equals(itemId)) {
                items.remove(i);
            }
        }
        return list;
    }

}
