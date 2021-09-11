package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentsListResponseDto {

    private Long id;
    private Long number;
    private String content;
    private LocalDateTime modifiedDate;
    private String name;

    public CommentsListResponseDto(Long id, Long number, String content, LocalDateTime modifiedDate, String name) {
        this.id = id;
        this.number = number;
        this.content = content;
        this.modifiedDate = modifiedDate;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CommentsListResponseDto{" +
                "id=" + id +
                ", number=" + number +
                ", content='" + content + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", name='" + name + '\'' +
                '}';
    }
}
