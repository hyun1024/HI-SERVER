package com.teamh.hiserver.Item.repository;

import com.teamh.hiserver.Item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
