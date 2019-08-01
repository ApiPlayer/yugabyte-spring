package com.yugabyte.springdemo.model;

import com.yugabyte.springdemo.model.util.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
public class ShoppingListDTO implements Serializable
{
    private UUID listId;

    private UUID userId;

    private String name;

    private String bannerName;

    private String description;

    private String displayName;

    private Map<UUID, ItemDTO> items;
}
