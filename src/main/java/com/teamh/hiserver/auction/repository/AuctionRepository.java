package com.teamh.hiserver.auction.repository;

import com.teamh.hiserver.Item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Item, Long> {
}
