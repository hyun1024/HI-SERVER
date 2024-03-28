package com.teamh.hiserver.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teamh.hiserver.notice.entity.Notice;


public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
