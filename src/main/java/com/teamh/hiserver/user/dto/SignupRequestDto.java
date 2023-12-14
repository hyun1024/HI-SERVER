package com.teamh.hiserver.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequestDto {
    private String loginId;
    private String nickname;
    private String password;
    private Boolean duplication;
}
