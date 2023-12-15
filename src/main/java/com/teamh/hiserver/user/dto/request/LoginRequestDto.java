package com.teamh.hiserver.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {
    private String loginId;
    private String password;
    private Boolean saveId;

}
