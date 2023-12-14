package com.teamh.hiserver.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class SignupResponseDto {
    private String loginId;

    @Builder
    public SignupResponseDto(String loginId) {
        this.loginId = loginId;
    }
}
