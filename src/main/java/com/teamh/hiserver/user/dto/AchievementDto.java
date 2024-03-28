package com.teamh.hiserver.user.dto;

import com.teamh.hiserver.user.entity.Medal;
import com.teamh.hiserver.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class AchievementDto {
    private Long achievementId;
    private Long medalId;
    private String name;
    private String imageUrl;
    private String description;
    private String loginId;
    private LocalDateTime achievementDate;

    @Builder
    public AchievementDto(Long achievementId, Long medalId, String name, String imageUrl, String description, String loginId, LocalDateTime achievementDate) {
        this.achievementId = achievementId;
        this.medalId = medalId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.loginId = loginId;
        this.achievementDate = achievementDate;
    }
}
