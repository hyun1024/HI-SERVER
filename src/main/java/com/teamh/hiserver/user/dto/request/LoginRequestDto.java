package com.teamh.hiserver.user.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {
    private String loginId;
    private String password;
    private Boolean saveCheck;

    @Builder
    public LoginRequestDto(String loginId, String password, Boolean saveCheck) {
        this.loginId = loginId;
        this.password = password;
        this.saveCheck = saveCheck;
    }
}
