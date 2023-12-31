package com.teamh.hiserver.auction.dto;

import com.teamh.hiserver.Item.entity.Item;
import com.teamh.hiserver.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuctionRequestDto {

    private Long userId;
    private Long itemId;
    private Long currentPrice;
    private Long quickSellPrice;
    private Long count;
}
