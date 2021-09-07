package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;
    private String content;

    public PostsListResponseDto(Long id, String title, String author, LocalDateTime modifiedDate, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.modifiedDate = modifiedDate;
        this.content = content;
    }
}

