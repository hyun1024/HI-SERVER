package com.teamh.hiserver.auction.entity;

import com.teamh.hiserver.Item.entity.Item;
import com.teamh.hiserver.user.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;
    @Column
    private Long currentPrice;
    @Column
    private Long quickSellPrice;
    @Column
    private LocalDateTime registrationTime;

    @Column
    private LocalDateTime dealTime;
}
