package com.teamh.hiserver.shop.repository;

import com.teamh.hiserver.shop.entity.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
}
