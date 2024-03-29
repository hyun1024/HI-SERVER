package com.teamh.hiserver.user.entity;

import com.teamh.hiserver.Item.entity.Item;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @Column
    private Long slotNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column
    private Long count;

    public Inventory(Long inventoryId, Long slotNumber, User user, Item item, Long count) {
        this.inventoryId = inventoryId;
        this.slotNumber = slotNumber;
        this.user = user;
        this.item = item;
        this.count = count;
    }

    public void setCount(Long inventoryId, Item item, Long count){
        this.item = item;
        this.count = count;
    }

    public void deal(User user){
        this.user = user;
    }

    public void moveItem(Item item, Long slotNumber){
        this.item= item;
        this.slotNumber = slotNumber;

    }
}
