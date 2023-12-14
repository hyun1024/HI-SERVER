package com.teamh.hiserver.user.entity;

import jakarta.persistence.*;

@Entity
public class Medal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medalId;
    @Column
    private String imageUrl;

}
