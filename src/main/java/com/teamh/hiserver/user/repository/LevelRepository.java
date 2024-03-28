package com.teamh.hiserver.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamh.hiserver.user.entity.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

}
