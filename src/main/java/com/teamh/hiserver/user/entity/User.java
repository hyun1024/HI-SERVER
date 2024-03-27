package com.teamh.hiserver.user.entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
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
    private Long level;
    @Column
    private Long exp;
    @Column
    private Long gold;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "medal_id")
    private Medal medal;
    
    
    
    @Builder
    public User(String loginId, String nickname, String password, Medal medal) {
        this.loginId = loginId;
        this.nickname = nickname;
        this.password = password;
        this.level = 1L;
        this.exp = 0L;
        this.gold = 0L;
        this.medal = medal;
    }
    
    public void updateProfile(String nickname, Medal medal) {
    	if(nickname!=null) this.nickname = nickname;
    	if(medal!=null) this.medal = medal;
    }
    public void updatePassword(String password) {
    	this.password = password;
    }
}
