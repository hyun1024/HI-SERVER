package com.teamh.hiserver.shop.service;

import com.teamh.hiserver.shop.repository.ShopItemRepository;
import com.teamh.hiserver.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final ShopItemRepository shopItemRepository;
}
