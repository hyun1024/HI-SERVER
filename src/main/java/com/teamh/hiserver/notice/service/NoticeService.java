package com.teamh.hiserver.notice.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;


import com.teamh.hiserver.notice.dto.NoticeRequestDto;
import com.teamh.hiserver.notice.dto.NoticeResponseDto;
import com.teamh.hiserver.notice.entity.Notice;
import com.teamh.hiserver.notice.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService {
	private final NoticeRepository noticeRepository;

	public NoticeResponseDto createNotice(NoticeRequestDto requestDto) {
		Notice notice = Notice
				.builder()
				.title(requestDto.getTitle())
				.content(requestDto.getContent())
				.createdAt(LocalDateTime.now())
				.build();
		noticeRepository.save(notice);
		return NoticeResponseDto
				.builder()
				.id(notice.getId())
				.title(notice.getTitle())
				.content(notice.getContent())
				.createdAt(notice.getCreatedAt())
				.build();
	}
}
