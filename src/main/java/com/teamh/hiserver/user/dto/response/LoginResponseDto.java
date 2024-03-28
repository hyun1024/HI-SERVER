package com.teamh.hiserver.user.dto.response;

import com.teamh.hiserver.user.entity.Medal;
import com.teamh.hiserver.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseDto {

    private String loginId;
    private String nickname;
    @Builder
    public LoginResponseDto(String loginId, String nickname) {
        this.loginId = loginId;
        this.nickname = nickname;
    }
}
