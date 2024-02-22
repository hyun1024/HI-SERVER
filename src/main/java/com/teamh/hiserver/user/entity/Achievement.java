package com.teamh.hiserver.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long achievementId;
    @ManyToOne
    @JoinColumn(name = "medal_id")
    private Medal medal;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private LocalDateTime achievementDate;

    @Builder
    public Achievement(Medal medal, User user) {
        this.medal = medal;
        this.user = user;
        this.achievementDate = LocalDateTime.now();
    }

    public Long getId() {
        return this.achievementId;
    }
}
