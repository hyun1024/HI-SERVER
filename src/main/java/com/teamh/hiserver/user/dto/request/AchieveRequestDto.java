package com.teamh.hiserver.user.dto.request;

import com.teamh.hiserver.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AchieveRequestDto {

    private String loginId;
    private Long medalId;
}
