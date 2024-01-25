package com.teamh.hiserver.shop.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long itemId;

    @Column
    private Long userId;

    @Column
    private LocalDateTime startTime;

    @Column
    private Long count;

    @Builder
    public Shop(Long id, Long itemId, Long userId, LocalDateTime startTime, Long count) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
        this.startTime = startTime;
        this.count = count;
    }
}
