package com.teamh.hiserver.inventory.entity;

import com.teamh.hiserver.Item.entity.Item;
import com.teamh.hiserver.user.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column
    private Long count;

    public Inventory(Long inventoryId, User user, Item item, Long count) {
        this.inventoryId = inventoryId;
        this.user = user;
        this.item = item;
        this.count = count;
    }
}
