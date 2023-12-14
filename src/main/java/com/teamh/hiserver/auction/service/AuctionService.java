package com.teamh.hiserver.auction.service;

import com.teamh.hiserver.Item.entity.Item;
import com.teamh.hiserver.auction.repository.AuctionRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final AuctionRepository auctionRepository;

    public void itemRegistration(Item item, HttpServletRequest request) {


    }
}
