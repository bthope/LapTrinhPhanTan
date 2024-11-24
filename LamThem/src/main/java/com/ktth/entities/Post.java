package com.ktth.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title",columnDefinition = "varchar(50)")
    private String title;
    @Column(name = "content",columnDefinition = "varchar(250)")
    private String content;
    @Column(name = "comment",columnDefinition = "varchar(250)")
    private String comment;
    @Column(name = "author",columnDefinition = "varchar(50)")
    private String author;

    public Post(String title, String content, String comment, String author) {
        this.title = title;
        this.content = content;
        this.comment = comment;
        this.author = author;
    }
}
