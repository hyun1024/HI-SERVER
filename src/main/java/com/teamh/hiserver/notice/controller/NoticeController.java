package com.teamh.hiserver.notice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamh.hiserver.notice.dto.NoticeRequestDto;
import com.teamh.hiserver.notice.dto.NoticeResponseDto;
import com.teamh.hiserver.notice.service.NoticeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notice")
public class NoticeController {
	
	private final NoticeService noticeService;
	
	@PostMapping("/")
	public ResponseEntity<NoticeResponseDto> createNotice(HttpServletRequest httpRequest, @RequestBody NoticeRequestDto requestDto){
		return ResponseEntity.ok().body(noticeService.createNotice(requestDto));
	}
}
