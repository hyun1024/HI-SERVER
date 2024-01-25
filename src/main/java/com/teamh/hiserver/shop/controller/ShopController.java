package com.teamh.hiserver.shop.controller;

import com.teamh.hiserver.shop.dto.PurchaseRequestDto;
import com.teamh.hiserver.shop.dto.PurchaseResponseDto;
import com.teamh.hiserver.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shop")
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/purchase/{shopId}")
    public ResponseEntity<PurchaseResponseDto> purchase(@PathVariable Long shopId, @RequestBody PurchaseRequestDto purchaseRequestDto){
        return ResponseEntity.ok().body(shopService.purchase(shopId, purchaseRequestDto));

    }
}
