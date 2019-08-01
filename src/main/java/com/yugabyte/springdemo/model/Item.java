package com.yugabyte.springdemo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.yugabyte.springdemo.model.util.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.awt.event.ItemEvent;
import java.io.Serializable;
import java.util.UUID;

@TypeDef(
    name = "jsonb",
    typeClass = JsonBinaryType.class
)

@Getter @Setter @NoArgsConstructor
public class Item implements Serializable
{
    private UUID itemId;

    private String itemName;

    private Integer quantity;

    private String categoryId;

    private String channel;

    public Item(ItemDTO dto) {
        this.itemId = dto.getItemId();
        this.itemName = dto.getItemName();
        this.quantity = dto.getQuantity();
        this.categoryId = dto.getCategoryId();
        this.channel = dto.getChannel();
    }

    public ItemDTO toDTO() {
        ItemDTO dto = new ItemDTO();
        dto.setItemId(this.itemId);
        dto.setItemName(this.itemName);
        dto.setQuantity(this.getQuantity());
        dto.setCategoryId(this.categoryId);
        dto.setChannel(this.channel);
        return dto;
    }


//    private WeeklyAdInfo weeklyAdInfo;

//    public Item(String itemId, String name, Integer quantity,
//        WeeklyAdInfo weeklyAdInfo)
//    {
//        this.itemId = itemId;
//        this.name = name;
//        this.quantity = quantity;
//        this.weeklyAdInfo = weeklyAdInfo;
//    }
}
