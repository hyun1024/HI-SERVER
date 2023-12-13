package com.teamh.hiserver.Item.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    @Column(nullable = false)
    private String imageUrl;
    @Column
    private Long itemType;
    @Column
    private Integer attack;
    @Column
    private Integer armor;
    @Column
    private Integer hp;
    @Column
    private Integer mp;
    @Column
    private Long price;
    @Column
    private Integer level;
    @Column
    private Integer strength;
    @Column
    private Integer dex;
    @Column
    private Integer intellect;
    @Column
    private Integer luck;

    public Item(Long itemId, String imageUrl, Long itemType, Integer attack, Integer armor, Integer hp, Integer mp, Long price, Integer level, Integer strength, Integer dex, Integer intellect, Integer luck) {
        this.itemId = itemId;
        this.imageUrl = imageUrl;
        this.itemType = itemType;
        this.attack = attack;
        this.armor = armor;
        this.hp = hp;
        this.mp = mp;
        this.price = price;
        this.level = level;
        this.strength = strength;
        this.dex = dex;
        this.intellect = intellect;
        this.luck = luck;
    }
}
