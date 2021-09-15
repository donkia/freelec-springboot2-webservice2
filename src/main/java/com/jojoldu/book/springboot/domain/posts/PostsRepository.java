package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p from Posts p order by p.id desc")
    List<Posts> findAllDesc();

    @Query("SELECT p from Posts p where p.content like concat('%', :search, '%') order by p.id desc")
    List<Posts> searchContentAllDesc(@Param("search") String search);

    @Query("SELECT p from Posts p where p.title like concat('%', :search, '%') order by p.id desc")
    List<Posts> searchTitleAllDesc(@Param("search") String search);

    @Query("SELECT p from Posts p where p.author like concat('%', :search, '%') order by p.id desc")
    List<Posts> searchAuthorAllDesc(@Param("search") String search);

    @Query("SELECT p from Posts p where rownum between :from and :to order by p.id")
    List<Posts> pagingfindAllDesc(@Param("from") int from, @Param("to") int to);

}
