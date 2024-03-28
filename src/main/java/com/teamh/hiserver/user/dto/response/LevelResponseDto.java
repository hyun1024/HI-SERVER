package com.teamh.hiserver.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LevelResponseDto {
	private Long level;
	private Long exp;
	
	
	@Builder
	public LevelResponseDto(Long level, Long exp) {
		this.level = level;
		this.exp = exp;
	}
}
