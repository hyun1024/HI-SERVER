package com.teamh.hiserver.user.dto.response;

import com.teamh.hiserver.user.entity.Medal;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileResponseDto {

    private String nickname;
    private Long level;
    private Long exp;
    private Long gold;
    private MedalResponseDto medal;

    @Builder
    public ProfileResponseDto(String nickname, Long level, Long exp, Long gold, MedalResponseDto medal) {
        this.nickname = nickname;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.medal = medal;
    }
}
