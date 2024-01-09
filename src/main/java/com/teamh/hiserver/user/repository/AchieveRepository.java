package com.teamh.hiserver.user.repository;

import com.teamh.hiserver.user.entity.Achievement;
import com.teamh.hiserver.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AchieveRepository extends JpaRepository<Achievement, Long> {
    Optional<Achievement> findByAchievementId(Long userId);
}
