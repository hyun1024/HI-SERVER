package com.teamh.hiserver.user.dto.response;

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
    private Long medal;

    @Builder
    public ProfileResponseDto(String nickname, Long level, Long exp, Long gold, Long medal) {
        this.nickname = nickname;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.medal = medal;
    }
}
