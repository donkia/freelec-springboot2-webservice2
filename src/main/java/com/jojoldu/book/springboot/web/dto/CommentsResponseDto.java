package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.comments.Comments;
import lombok.Getter;

@Getter
public class CommentsResponseDto {

    private Long id;
    private String content;
    private Long number;
    private String name;

    public CommentsResponseDto(Comments entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.number = entity.getNumber();
        this.name = entity.getName();
    }

    @Override
    public String toString() {
        return "CommentsResponseDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
