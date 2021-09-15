package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;
    private Long commentCnt;
    private Long hit;

    @Builder

    public PostsSaveRequestDto(String title, String content, String author, Long commentCnt, Long hit) {

        this.title = title;
        this.content = content;
        this.author = author;
        this.commentCnt = commentCnt;
        this.hit = hit;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .commentCnt(commentCnt)
                .hit(0L)
                .build();
    }
}
