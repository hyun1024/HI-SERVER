package com.teamh.hiserver.global.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ValidMessageDto {
	
	private String field;
	private String message;
	
	@Builder
	public ValidMessageDto(String field, String message) {
		this.field=field;
		this.message=message;
	}
}
