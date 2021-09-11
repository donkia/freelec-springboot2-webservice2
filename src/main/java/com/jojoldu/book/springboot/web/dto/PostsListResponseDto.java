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
    private Long commentCnt;

    public PostsListResponseDto(Long id, String title, String author, LocalDateTime modifiedDate, String content, Long commentCnt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.modifiedDate = modifiedDate;
        this.content = content;
        this.commentCnt = commentCnt;
    }

    @Override
    public String toString() {
        return "PostsListResponseDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", content='" + content + '\'' +
                ", commentCnt=" + commentCnt +
                '}';
    }
}

