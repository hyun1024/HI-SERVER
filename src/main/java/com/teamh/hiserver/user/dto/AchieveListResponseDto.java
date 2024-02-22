package com.teamh.hiserver.user.dto;

import com.teamh.hiserver.user.entity.Achievement;
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
