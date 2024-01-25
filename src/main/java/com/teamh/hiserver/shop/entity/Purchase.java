package com.teamh.hiserver.shop.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long itemId;

    @Column
    private Long userId;

    @Column
    private Long count;

    @Column
    private LocalDateTime purchaseTime;

    @Builder
    public Purchase(Long id, Long itemId, Long userId, Long count) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
        this.purchaseTime = LocalDateTime.now();
        this.count = count;
    }
}
