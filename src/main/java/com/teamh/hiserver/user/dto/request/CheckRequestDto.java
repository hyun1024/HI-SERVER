package com.teamh.hiserver.user.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckRequestDto {

    private String loginId;

    @Builder
    public CheckRequestDto(String loginId) {
        this.loginId = loginId;
    }
}
