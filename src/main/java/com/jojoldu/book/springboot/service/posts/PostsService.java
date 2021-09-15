package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id : " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(Posts->new PostsListResponseDto(Posts.getId(), Posts.getTitle()
                , Posts.getAuthor(), Posts.getModifiedDate(), Posts.getContent(), Posts.getCommentCnt(), Posts.getHit()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts post = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        postsRepository.delete(post);
    }

    @Transactional
    public Long UpdateCommentCnt(Long id){
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        post.UpdateCommentCnt();
        return id;
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> searchContentAllDesc(String search){
        return postsRepository.searchContentAllDesc(search).stream().map(Posts->new PostsListResponseDto(Posts.getId(), Posts.getTitle()
                        , Posts.getAuthor(), Posts.getModifiedDate(), Posts.getContent(), Posts.getCommentCnt(), Posts.getHit()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> searchTitleAllDesc(String search){
        return postsRepository.searchTitleAllDesc(search).stream().map(Posts->new PostsListResponseDto(Posts.getId(), Posts.getTitle()
                        , Posts.getAuthor(), Posts.getModifiedDate(), Posts.getContent(), Posts.getCommentCnt(), Posts.getHit()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> searchAuthorAllDesc(String search){
        return postsRepository.searchAuthorAllDesc(search).stream().map(Posts->new PostsListResponseDto(Posts.getId(), Posts.getTitle()
                        , Posts.getAuthor(), Posts.getModifiedDate(), Posts.getContent(), Posts.getCommentCnt(), Posts.getHit()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> pagingfindAllDesc(int from, int to){
        return postsRepository.pagingfindAllDesc(from, to).stream().map(Posts->new PostsListResponseDto(Posts.getId(), Posts.getTitle()
                        , Posts.getAuthor(), Posts.getModifiedDate(), Posts.getContent(), Posts.getCommentCnt(), Posts.getHit()))
                .collect(Collectors.toList());
    }

    @Transactional
    public Long updateHit(Long id){
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        post.updateHit();
        return id;
    }




}
