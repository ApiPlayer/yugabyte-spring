package com.yugabyte.springdemo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.*;

import java.io.Serializable;

public class Item implements Serializable
{
    @Id
    @JsonProperty
    private String itemId;

    @JsonProperty
    private String name;

    @JsonProperty
    private Integer quantity;

    @JsonCreator
    public Item(String itemId, String name, Integer quantity)
    {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getItemId()
    {
        return itemId;
    }

    public void setItemId(String itemId)
    {
        this.itemId = itemId;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public void incQuantity() {
        quantity++;
    }

    public void decQuantity() {
        quantity--;
    }
}
