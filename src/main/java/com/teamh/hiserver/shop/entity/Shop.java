package com.teamh.hiserver.shop.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

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
    private LocalDateTime boughtTime;

    @Column
    private Long count;

    @Builder
    public Shop(Long id, Long itemId, Long userId, LocalDateTime boughtTime, Long count) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
        this.boughtTime = boughtTime;
        this.count = count;
    }
}
