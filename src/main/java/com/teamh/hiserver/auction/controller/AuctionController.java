package com.teamh.hiserver.auction.controller;

import com.teamh.hiserver.auction.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuctionController {
    private final AuctionService auctionService;
}
