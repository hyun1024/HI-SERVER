package com.teamh.hiserver.user.repository;

import com.teamh.hiserver.user.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
	List<Achievement> findByUserLoginId(String loginId);
}