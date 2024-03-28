package com.teamh.hiserver.user.repository;

import com.teamh.hiserver.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
//    Optional<User> findByLoginId(String loginId);
//    Optional<User> findByUserId(Long userId);
}
