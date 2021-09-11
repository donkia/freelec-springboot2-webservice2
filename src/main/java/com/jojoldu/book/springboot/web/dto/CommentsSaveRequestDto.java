package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.comments.Comments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {

    private Long number;
    private String content;
    private String name;

    @Builder
    public CommentsSaveRequestDto(Long id, Long number, String content, String name) {
        this.number = number;
        this.content = content;
        this.name = name;
    }

    public Comments toEntity(){
        return Comments.builder()
                .number(number)
                .content(content)
                .name(name)
                .build();
    }
}
