package com.teamh.hiserver.user.repository;

import com.teamh.hiserver.user.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchieveRepository extends JpaRepository<Achievement, Long> {
}
