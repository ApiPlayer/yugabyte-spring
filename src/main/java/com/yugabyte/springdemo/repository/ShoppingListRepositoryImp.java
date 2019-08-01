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
    public ShoppingList findList(UUID listId) {
        ShoppingList shoppingList = entityManager.find(ShoppingList.class, listId);
        return shoppingList;
    }

    @Override
    @Transactional
    public ShoppingList addItem(UUID listId, Item item) {
        ShoppingList list = findList(listId);
        list.getItems().put(item.getItemId(), item);
        return saveList(list);
    }

//    @Override
//    @Transactional
//    public ShoppingList incQuantity(UUID listId, String itemId) {
//        ShoppingList list = findList(listId);
//        for (Item item: list.getItems()) {
//            if (item.getItemId().equals(itemId)) {
//                item.incQuantity();
//            }
//        }
//        return list;
//    }
//
//    @Override
//    @Transactional
//    public ShoppingList decQuantity(UUID listId, String itemId) {
//        ShoppingList list = findList(listId);
//        for (Item item: list.getItems()) {
//            if (item.getItemId().equals(itemId)) {
//                item.decQuantity();
//            }
//        }
//        return list;
//    }

    @Override
    @Transactional
    public ShoppingList updateQuantity(UUID listId, UUID itemId, int delta) {
        ShoppingList list = findList(listId);
        Item item = list.getItems().get(itemId);
        item.setQuantity(item.getQuantity() + delta);
        return saveList(list);
    }

    @Override
    @Transactional
    public ShoppingList deleteList(UUID listId) {
        ShoppingList list = findList(listId);
        entityManager.remove(list);
        return list;
    }

    @Override
    @Transactional
    public ShoppingList deleteItem(UUID listId, UUID itemId) {
        ShoppingList list = findList(listId);
        Map<UUID, Item> items = list.getItems();
        items.remove(itemId);
        return list;
    }

}
