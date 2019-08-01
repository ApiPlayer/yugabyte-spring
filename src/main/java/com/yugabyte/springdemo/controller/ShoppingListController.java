package com.yugabyte.springdemo.controller;

import com.yugabyte.springdemo.model.Item;
import com.yugabyte.springdemo.model.ShoppingListDTO;
import com.yugabyte.springdemo.repository.ShoppingListJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yugabyte.springdemo.repository.ShoppingListRepository;
import com.yugabyte.springdemo.model.ShoppingList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Set;
import java.util.UUID;

@RestController
@Api(value = "ShoppingList", tags={"ShoppingList"})
public class ShoppingListController
{
    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private ShoppingListJPARepository shoppingListJPARepository;

    //TODO: exception handling

    // http://localhost:8080/swagger-ui.html

    @ApiOperation(value = "Create a shopping list")
    @PostMapping("/lists")
    public ShoppingListDTO createShoppingList(@RequestBody ShoppingListDTO shoppingListDTO) {
        ShoppingList newList = new ShoppingList(shoppingListDTO);
        ShoppingList savedList = shoppingListRepository.saveList(newList);
        return savedList.toDTO();
    }

    @ApiOperation(value = "Get a shopping list by id")
    @GetMapping("/lists/{listId}")
    public ShoppingListDTO findShoppingList(@PathVariable UUID listId) {
        ShoppingList sl = shoppingListRepository.findList(listId);
//        System.out.println(sl.getItems().get("f1984448-fba9-4821-b3c0-47ca12dd1c27"));
        return sl.toDTO();
    }

    @ApiOperation(value = "Add an item to a shoppingList")
    @PostMapping("/lists/{listId}")
    public ShoppingList addItem(@PathVariable UUID listId, @RequestBody Item item) {
        return shoppingListRepository.addItem(listId, item);
    }

//    @ApiOperation(value = "Increment the quantity of an item")
//    @PutMapping("/lists/{listId}/inc/{itemId}")
//    public ShoppingList incItem(@PathVariable String listId, @PathVariable String itemId) {
//        return shoppingListRepository.incQuantity(listId, itemId);
//    }
//
//    @ApiOperation(value = "Decrement the quantity of an item")
//    @PutMapping("/lists/{listId}/dec/{itemId}")
//    public ShoppingList decItem(@PathVariable String listId, @PathVariable String itemId) {
//        return shoppingListRepository.decQuantity(listId, itemId);
//    }

    @ApiOperation(value = "Update the quantity of an item by delta")
    @PutMapping("/lists/{listId}/update/{itemId}/{delta}")
    public ShoppingList updateItem(@PathVariable UUID listId, @PathVariable UUID itemId, @PathVariable Integer delta) {
        return shoppingListRepository.updateQuantity(listId, itemId, delta);
    }

    @ApiOperation(value = "Delete a shopping list by id")
    @DeleteMapping("/lists/{listId}")
    public ShoppingList deleteList(@PathVariable UUID listId) {
        return shoppingListRepository.deleteList(listId);
    }

    @ApiOperation(value = "Delete an item by id")
    @DeleteMapping("/lists/{listId}/{itemId}")
    public ShoppingList deleteItem(@PathVariable UUID listId, @PathVariable UUID itemId) {
        return shoppingListRepository.deleteItem(listId, itemId);
    }

}

