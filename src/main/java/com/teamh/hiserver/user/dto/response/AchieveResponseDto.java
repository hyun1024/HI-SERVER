package com.teamh.hiserver.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AchieveResponseDto {
    private Long medalId;
    private String medalName;
    private String medalUrl;


    @Builder
    public AchieveResponseDto(Long medalId, String medalName, String medalUrl){
        this.medalId = medalId;
        this.medalName = medalName;
        this.medalUrl = medalUrl;
    }
}
