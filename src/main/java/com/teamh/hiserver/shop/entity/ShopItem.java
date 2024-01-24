package com.teamh.hiserver.shop.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long itemId;

    @Column
    private Long count;

    @Builder
    public ShopItem(Long id, Long itemId, Long count) {
        this.id = id;
        this.itemId = itemId;
        this.count = count;
    }
}
