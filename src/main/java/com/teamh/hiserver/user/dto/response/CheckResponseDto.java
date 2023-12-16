package com.teamh.hiserver.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckResponseDto {
    private String loginId;
    private Boolean isUsableId;

    @Builder
    public CheckResponseDto(String loginId, Boolean isUsableId) {
        this.loginId = loginId;
        this.isUsableId = isUsableId;
    }
}
