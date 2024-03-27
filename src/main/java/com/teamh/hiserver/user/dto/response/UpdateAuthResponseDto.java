package com.teamh.hiserver.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateAuthResponseDto {
    private Boolean isCorrect;
    
    
    @Builder
    public UpdateAuthResponseDto(boolean isCorrect) {
    	this.isCorrect=isCorrect;
    }
}
