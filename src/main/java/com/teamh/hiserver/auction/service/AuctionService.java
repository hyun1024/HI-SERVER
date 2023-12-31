package com.teamh.hiserver.auction.service;

import com.teamh.hiserver.Item.entity.Item;
import com.teamh.hiserver.auction.dto.AuctionRequestDto;
import com.teamh.hiserver.auction.repository.AuctionRepository;
import com.teamh.hiserver.user.entity.User;
import com.teamh.hiserver.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final UserRepository userRepository;

    public void registerItem(AuctionRequestDto auctionRequestDto, HttpServletRequest request) {
        User user = userRepository.findByUserId(auctionRequestDto.getUserId()).orElseThrow(()->new NullPointerException("존재하지 않는 유저입니다"));

    }
}
