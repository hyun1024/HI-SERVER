package com.teamh.hiserver.user.repository;

import com.teamh.hiserver.user.entity.Medal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedalRepository extends JpaRepository<Medal, Long> {
    Optional<Medal> findByMedalId(Long medalId);
}
