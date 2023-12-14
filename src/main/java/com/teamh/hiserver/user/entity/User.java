package com.teamh.hiserver.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String loginId;
    @Column
    private String nickname;
    @Column
    private String password;
    @Column
    private Integer level;
    @Column
    private Long exp;
    @Column
    private Long gold;
    @Column
    private Long medal;
    @Builder
    public User(Long userId, String loginId, String nickname, String password, Integer level, Long exp, Long gold, Long medal) {
        this.userId = userId;
        this.loginId = loginId;
        this.nickname = nickname;
        this.password = password;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.medal = medal;
    }
}
