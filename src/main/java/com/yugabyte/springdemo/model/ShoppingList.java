package com.yugabyte.springdemo.model;

import javax.persistence.*;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import java.io.Serializable;
import java.util.List;

@Entity(name = "ShoppingList")
@Table(name = "lists")
@TypeDef(
    name = "jsonb",
    typeClass = JsonBinaryType.class
)
public class ShoppingList implements Serializable
{
    @Id
    private String listId;

    private String userId;

    private String description;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<Item> items;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public ShoppingList(){}

    public ShoppingList(String listId, String userId, String description, List<Item> items) {
        this.listId = listId;
        this.userId = userId;
        this.description = description;
        this.items = items;
    }

    public String getListId()
    {
        return listId;
    }

    public void setListId(String listId)
    {
        this.listId = listId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<Item> getItems()
    {
        return items;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }
}
