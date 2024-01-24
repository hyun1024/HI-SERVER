package com.teamh.hiserver.shop.controller;

import com.teamh.hiserver.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shop")
public class ShopController {
    private final ShopService shopService;

}
