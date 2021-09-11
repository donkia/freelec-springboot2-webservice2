package com.jojoldu.book.springboot.domain.comments;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 원래글의 번호
    private Long number;

    // 댓글 내용
    private String content;

    // 작성자
    private String name;


    @Builder
    public Comments(Long number, String content, String name) {
        this.number = number;
        this.content = content;
        this.name = name;

    }

    public void update(String content) {
        this.content = content;
    }

}
