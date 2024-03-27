package com.teamh.hiserver.Item.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    @Column(nullable = false)
    private String itemName;
    @Column(nullable = false)
    private String imageUrl;
    @Column
    private String itemType;
    @Column
    private Long price;
    @Column
    private Integer usableLv;

    @Builder
    public Item(Long itemId, String itemName, String imageUrl, String itemType, Long price, Integer level) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.imageUrl = imageUrl;
        this.itemType = itemType;
        this.price = price;
        this.usableLv = level;
    }
}
