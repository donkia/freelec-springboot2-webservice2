package com.jojoldu.book.springboot.service.Comments;


import com.jojoldu.book.springboot.domain.comments.Comments;
import com.jojoldu.book.springboot.domain.comments.CommentsRepository;
import com.jojoldu.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    @Transactional
    public Long save(CommentsSaveRequestDto requestDto){
        return commentsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<CommentsListResponseDto> findAllDesc(Long id){
        return commentsRepository.findAllDesc(id).stream().map(Comments ->
                new CommentsListResponseDto(Comments.getId(),
                    Comments.getNumber(), Comments.getContent(),
                        Comments.getModifiedDate(), Comments.getName())).
                collect(Collectors.toList());
    }

    public CommentsResponseDto findById(Long id){
        Comments entity = commentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글에 댓글이 없습니다. id : " + id));
        return new CommentsResponseDto(entity);
    }

    public List<CommentsListResponseDto> findById2(Long id){
        //Optional<Comments> entity = commentsRepository.findById(id);
        //System.out.println("entity : " + entity);
        //return entity;
        return commentsRepository.findAllDesc(id).stream().map(Comments ->
                new CommentsListResponseDto(Comments.getId(), Comments.getNumber(),
                        Comments.getContent(), Comments.getModifiedDate(),
                        Comments.getName())).collect(Collectors.toList());
    }
}
