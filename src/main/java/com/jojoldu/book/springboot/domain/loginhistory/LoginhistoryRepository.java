package com.jojoldu.book.springboot.domain.loginhistory;

import com.jojoldu.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginhistoryRepository extends JpaRepository<Loginhistory, Long> {

    @Query("SELECT l from Loginhistory l order by l.id desc")
    List<Loginhistory> findAllDesc();
}
