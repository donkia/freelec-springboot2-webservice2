package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String title;

    private String content;

    private String author;

    //댓글수
    @ColumnDefault("0")
    private Long commentCnt;

    //조회수
    @ColumnDefault("0")
    private Long hit;


    @Builder
    public Posts(String title, String content, String author, Long commentCnt, Long hit) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.commentCnt = commentCnt;
        this.hit = hit;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    // 게시물에 댓글 갯수 카운트
    public void UpdateCommentCnt(){
        this.commentCnt ++;

    }

    public void updateHit(){
        this.hit ++;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", commentCnt=" + commentCnt +
                ", hit=" + hit +
                '}';
    }
}
