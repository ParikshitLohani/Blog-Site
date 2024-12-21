package com.parikshit.blog.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    public Blog() {}

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
