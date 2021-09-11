package com.jojoldu.book.springboot.domain.comments;

import com.jojoldu.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PreDestroy;
import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    @Query("SELECT c from Comments c where c.number = :id order by c.createdDate desc")
    List<Comments> findAllDesc(@Param("id") Long id);

}
