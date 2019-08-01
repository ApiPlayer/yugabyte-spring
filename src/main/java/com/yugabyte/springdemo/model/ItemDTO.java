package com.yugabyte.springdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
public class ItemDTO implements Serializable
{
    private UUID itemId;

    private String itemName;

    private Integer quantity;

    private String categoryId;

    private String channel;

    private WeeklyAdInfo weeklyAdInfo;

    public ItemDTO(LinkedHashMap<String, String> map) {
        this.itemId = UUID.fromString(map.get("itemId"));
        this.itemName = map.get("itemName");
        this.quantity = Integer.valueOf(map.get("quantity"));
        this.categoryId = map.get("categoryId");
        this.channel = map.get("channel");
    }

}
