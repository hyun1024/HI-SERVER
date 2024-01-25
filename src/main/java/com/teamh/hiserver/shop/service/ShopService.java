package com.teamh.hiserver.shop.service;

import com.teamh.hiserver.Item.repository.ItemRepository;
import com.teamh.hiserver.shop.dto.PurchaseRequestDto;
import com.teamh.hiserver.shop.dto.PurchaseResponseDto;
import com.teamh.hiserver.shop.entity.Purchase;
import com.teamh.hiserver.shop.entity.Shop;
import com.teamh.hiserver.shop.repository.PurchaseRepository;
import com.teamh.hiserver.shop.repository.ShopRepository;
import com.teamh.hiserver.user.entity.User;
import com.teamh.hiserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;

    public PurchaseResponseDto purchase(Long shopId, PurchaseRequestDto purchaseRequestDto) {
        Shop shop = shopRepository.findById(shopId).orElseThrow(()->new NullPointerException("유효한 상점이 아닙니다."));
        User user = userRepository.findByUserId(purchaseRequestDto.getUserId()).orElseThrow(()->new NullPointerException("유효한 유저가 아닙니다."));
        Purchase purchase = Purchase.builder()
                .count(purchaseRequestDto.getCount())
                .userId(user.getUserId())
                .itemId(purchaseRequestDto.getItemId())
                .build();
        purchaseRepository.save(purchase);
        return PurchaseResponseDto.builder()
                .userId(purchase.getUserId())
                .itemId(purchase.getItemId())
                .count(purchase.getCount())
                .build();
    }
}
