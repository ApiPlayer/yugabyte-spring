package com.yugabyte.springdemo.controller;

import com.yugabyte.springdemo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yugabyte.springdemo.repository.ShoppingListRepository;
import com.yugabyte.springdemo.model.ShoppingList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "ShoppingList", tags={"ShoppingList"})
public class ShoppingListController
{
    @Autowired
    private ShoppingListRepository shoppingListRepository;

    //TODO: exception handling

    // http://localhost:8080/swagger-ui.html

    @ApiOperation(value = "Create a shopping list")
    @PostMapping("/lists")
    public ShoppingList createShoppingList(@RequestBody ShoppingList shoppingList) {
        shoppingListRepository.saveList(shoppingList);
        return shoppingList;
    }

    @ApiOperation(value = "Get a shopping list by id")
    @GetMapping("/lists/{listId}")
    public ShoppingList findShoppingList(@PathVariable String listId) {
        return shoppingListRepository.findList(listId);
    }

    @ApiOperation(value = "Add an item to a shoppingList")
    @PostMapping("/lists/{listId}")
    public ShoppingList addItem(@PathVariable String listId, @RequestBody Item item) {
        return shoppingListRepository.addItem(listId, item);
    }

    @ApiOperation(value = "Increment the quantity of an item")
    @PutMapping("/lists/{listId}/inc/{itemId}")
    public ShoppingList incItem(@PathVariable String listId, @PathVariable String itemId) {
        return shoppingListRepository.incQuantity(listId, itemId);
    }

    @ApiOperation(value = "Decrement the quantity of an item")
    @PutMapping("/lists/{listId}/dec/{itemId}")
    public ShoppingList decItem(@PathVariable String listId, @PathVariable String itemId) {
        return shoppingListRepository.decQuantity(listId, itemId);
    }

    @ApiOperation(value = "Update the quantity of an item by user specified value")
    @PutMapping("/lists/{listId}/update/{itemId}/{newQuantity}")
    public ShoppingList updateItem(@PathVariable String listId, @PathVariable String itemId, @PathVariable Integer newQuantity) {
        return shoppingListRepository.updateQuantity(listId, itemId, newQuantity);
    }

    @ApiOperation(value = "Delete a shopping list by id")
    @DeleteMapping("/lists/{listId}")
    public ShoppingList deleteList(@PathVariable String listId) {
        return shoppingListRepository.deleteList(listId);
    }

    @ApiOperation(value = "Delete an item by id")
    @DeleteMapping("/lists/{listId}/{itemId}")
    public ShoppingList deleteItem(@PathVariable String listId, @PathVariable String itemId) {
        return shoppingListRepository.deleteItem(listId, itemId);
    }

}

