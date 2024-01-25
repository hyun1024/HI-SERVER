package com.teamh.hiserver.shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PurchaseResponseDto {
    private Long itemId;
    private Long userId;
    private Long count;

    @Builder
    public PurchaseResponseDto(Long itemId, Long userId, Long count) {
        this.itemId = itemId;
        this.userId = userId;
        this.count = count;
    }
}
