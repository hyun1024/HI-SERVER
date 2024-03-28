package com.teamh.hiserver.notice.dto;

import java.time.LocalDateTime;
import lombok.Builder;

public class NoticeResponseDto {
	
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    
    
    @Builder
    public NoticeResponseDto(Long id, String title, String content, LocalDateTime createdAt) {
    	this.id= id;
    	this.title = title;
    	this.content = content;
    	this.createdAt = createdAt;
    }
}
