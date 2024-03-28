package com.teamh.hiserver.shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PurchaseRequestDto {

    private Long itemId;
    private String loginId;
    private Long count;

}
