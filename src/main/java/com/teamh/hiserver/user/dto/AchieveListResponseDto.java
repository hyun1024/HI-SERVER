package com.teamh.hiserver.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class AchieveListResponseDto {
    List<AchievementDto> achievementDtoList;

    @Builder
    public AchieveListResponseDto(List<AchievementDto> achievementDtoList) {
        this.achievementDtoList = achievementDtoList;
    }
}
