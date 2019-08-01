package com.yugabyte.springdemo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yugabyte.springdemo.model.util.JsonBinaryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Type;
//import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import java.io.Serializable;
import java.util.*;

@Entity
//@Table(name="lists")
@Table(name="shopping_lists_json")
@TypeDef(
    name = "jsonb",
    typeClass = JsonBinaryType.class
)

@Getter @Setter @NoArgsConstructor
public class ShoppingList implements Serializable
{
    @Id
    private UUID listId;

    private UUID userId;

    private String name;

    private String bannerName;

    private String description;

//    @Transient
//    private int itemCount;
    private String type = "normal";

    private String displayName;

    @Type(type = "jsonb")
    private Map<UUID, Item> items;
//    private List<Item> items;

    public ShoppingList(ShoppingListDTO dto) {
        this.listId = dto.getListId();
        this.userId = dto.getUserId();
        this.name = dto.getName();
        this.bannerName = dto.getBannerName();
        this.description = dto.getDescription();
        this.displayName = dto.getDisplayName();
        this.items = copyMapFromDTO(dto.getItems());
    }

    public ShoppingListDTO toDTO() {
        ShoppingListDTO dto = new ShoppingListDTO();
        dto.setListId(this.listId);
        dto.setUserId(this.userId);
        dto.setName(this.name);
        dto.setBannerName(this.bannerName);
        dto.setDescription(this.description);
        dto.setDisplayName(this.displayName);
        dto.setItems(copyMapToDTO(this.items));
        return dto;
    }

    private Map<UUID, ItemDTO> copyMapToDTO(Map<UUID, Item> map) {
        Map<UUID, ItemDTO> items = new HashMap<>();
        for (Map.Entry<UUID, Item> e : map.entrySet()) {
            items.put(e.getKey(), e.getValue().toDTO());  // can't call toDTO() method; the value here is LinkedHashMap instead of Item
        }
        return items;
    }


    private Map<UUID, Item> copyMapFromDTO(Map<UUID, ItemDTO> map) {
        Map<UUID, Item> items = new HashMap<>();
        for (Map.Entry<UUID, ItemDTO> e : map.entrySet()) {
            items.put(e.getKey(), new Item(e.getValue()));
        }
        return items;
    }

//    @Type(type = "jsonb")
//    @Setter(AccessLevel.NONE)
//    private LegacyType type = new LegacyType();

//    @Getter @Setter @NoArgsConstructor
//    private static class LegacyType {
//        private final String type = "normal";
//    }

//    @PrePersist
//    public void generateItemCount() {
//        setItemCount(items.size());
//    }
//
//    @PreUpdate
//    public void updateItemCount() {
//        setItemCount(items.size());
//    }
}
