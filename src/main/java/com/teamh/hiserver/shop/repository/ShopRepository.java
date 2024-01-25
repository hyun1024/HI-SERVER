package com.teamh.hiserver.shop.repository;

import com.teamh.hiserver.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findById(Long shopId);

}
