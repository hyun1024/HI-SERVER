package com.teamh.hiserver.user.entity;

import com.teamh.hiserver.user.dto.SignupRequestDto;
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
    public User(String loginId, String nickname, String password) {
        this.loginId = loginId;
        this.nickname = nickname;
        this.password = password;
        this.level = 1;
        this.exp = 0L;
        this.gold = 0L;
        this.medal = -1L;
    }
}
