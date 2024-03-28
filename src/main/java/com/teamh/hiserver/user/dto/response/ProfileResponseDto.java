package com.teamh.hiserver.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileResponseDto {

    private String nickname;
    private LevelResponseDto level;
    private Long exp;
    private Long gold;
    private Long levelUpExp;
    private MedalResponseDto medal;

    @Builder
    public ProfileResponseDto(String nickname, LevelResponseDto level, Long exp, Long gold, Long levelUpExp, MedalResponseDto medal) {
        this.nickname = nickname;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.levelUpExp = levelUpExp;
        this.medal = medal;

    }
}
