package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.Comments.CommentsService;
import com.jojoldu.book.springboot.service.EmailService;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.service.posts.PostsUpdateRequestDto;
import com.jojoldu.book.springboot.web.dto.CommentsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RequiredArgsConstructor
@RestController
//@PropertySource("classpath:")
public class PostsApiController {

    private final PostsService postsService;
    private final CommentsService commentsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) throws MessagingException {

        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){

        return postsService.findById(id);

    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete (@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    @PostMapping("/api/v1/commentsPost")
    public Long CommentSave(@RequestBody CommentsSaveRequestDto requestDto) throws MessagingException {
        postsService.UpdateCommentCnt(requestDto.getNumber());
        return commentsService.save(requestDto);

    }




}
