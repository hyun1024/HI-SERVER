package com.teamh.hiserver.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Medal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medalId;
    @Column
    private String name;
    @Column
    private String imageUrl;
    @Column
    private String description;

}
