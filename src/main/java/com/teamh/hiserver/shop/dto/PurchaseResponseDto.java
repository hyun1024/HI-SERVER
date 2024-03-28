package com.teamh.hiserver.shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PurchaseResponseDto {
    private Long itemId;
    private String loginId;
    private Long count;

    @Builder
    public PurchaseResponseDto(Long itemId, String loginId, Long count) {
        this.itemId = itemId;
        this.loginId = loginId;
        this.count = count;
    }
}
