package com.teamh.hiserver.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class MedalResponseDto {
	
    private Long medalId;
    private String name;
    private String imageUrl;
    private String description;
    
    
    @Builder
    public MedalResponseDto(Long medalId, String name, String imageUrl, String description) {
    	this.medalId = medalId;
    	this.name = name;
    	this.imageUrl = imageUrl;
    	this.description = description;
    }
}
