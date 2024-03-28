package com.teamh.hiserver.notice.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@Getter
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String title;
    
    @Column
    private String content;
    
    @Column
    private LocalDateTime createdAt;
    
    
    @Builder
    public Notice(String title, String content, LocalDateTime createdAt) {
    	this.title = title;
    	this.content = content;
    	this.createdAt = createdAt;
    }
}
