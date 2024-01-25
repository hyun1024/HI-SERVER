package com.teamh.hiserver.shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PurchaseRequestDto {

    private Long itemId;
    private Long userId;
    private Long count;

}
