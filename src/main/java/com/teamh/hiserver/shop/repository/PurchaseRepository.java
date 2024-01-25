package com.teamh.hiserver.shop.repository;

import com.teamh.hiserver.shop.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
