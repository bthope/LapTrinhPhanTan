package com.ktth.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateRequest {
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
}
