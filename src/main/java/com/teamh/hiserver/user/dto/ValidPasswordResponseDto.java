package com.teamh.hiserver.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ValidPasswordResponseDto {

	private Boolean isUsablePassword;

	@Builder
	public ValidPasswordResponseDto(Boolean isUsablePassword) {
		this.isUsablePassword = isUsablePassword;
	}
}
