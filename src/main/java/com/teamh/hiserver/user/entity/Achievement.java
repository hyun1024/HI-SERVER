package com.teamh.hiserver.user.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//Medal과 User의 중간테이블
@Entity
@NoArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long achivementId;
    @ManyToOne
    @JoinColumn(name = "medal_id")
    private Medal medal;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private LocalDateTime achievementDate;

    public Achievement(Long achivementId, Medal medal, User user, LocalDateTime achievementDate) {
        this.achivementId = achivementId;
        this.medal = medal;
        this.user = user;
        this.achievementDate = achievementDate;
    }
}
