package com.yugabyte.springdemo.repository;

import com.yugabyte.springdemo.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShoppingListJPARepository extends JpaRepository<ShoppingList, String>
{
    ShoppingList findShoppingListByListId(String listId);
}
