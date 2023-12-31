package com.teamh.hiserver.auction.controller;

import com.teamh.hiserver.Item.entity.Item;
import com.teamh.hiserver.auction.dto.AuctionRequestDto;
import com.teamh.hiserver.auction.service.AuctionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuctionController {
    private final AuctionService auctionService;

    @RequestMapping("/auction/register")
    public void registerItem(@RequestBody AuctionRequestDto auctionRequestDto, HttpServletRequest request){
        auctionService.registerItem(auctionRequestDto, request);
    }
}
