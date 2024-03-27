package com.teamh.hiserver.user.dto.response;

import com.teamh.hiserver.user.entity.Medal;
import com.teamh.hiserver.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseDto {

    private Long userId;
    private String nickname;
    private Medal medal;
    private Long level;
    private Long exp;
    private Long gold;

    @Builder
    public LoginResponseDto(Long userId, String nickname, Medal medal, Long level, Long exp, Long gold) {
        this.userId = userId;
        this.nickname = nickname;
        this.medal = medal;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
    }
}
