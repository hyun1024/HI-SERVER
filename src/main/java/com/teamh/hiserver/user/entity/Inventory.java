package com.teamh.hiserver.user.entity;

import com.teamh.hiserver.Item.entity.Item;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column
    private Integer slot;

    public Inventory(Long id, User user, Item item, Integer slot) {
        this.id = id;
        this.user = user;
        this.item = item;
        this.slot = slot;
    }
}
