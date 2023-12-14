package com.teamh.hiserver.user.repository;

import com.teamh.hiserver.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
