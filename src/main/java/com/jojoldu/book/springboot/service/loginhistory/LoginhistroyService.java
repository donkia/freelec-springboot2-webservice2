package com.jojoldu.book.springboot.service.loginhistory;


import com.jojoldu.book.springboot.domain.loginhistory.Loginhistory;
import com.jojoldu.book.springboot.domain.loginhistory.LoginhistoryRepository;
import com.jojoldu.book.springboot.web.dto.CommentsListResponseDto;
import com.jojoldu.book.springboot.web.dto.CommentsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.LoginhistoryListResponseDto;
import com.jojoldu.book.springboot.web.dto.LoginhistoryRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginhistroyService {

    private final LoginhistoryRepository loginhistoryRepository;

    @Transactional
    public Long save(LoginhistoryRequestDto requestDto){
        return loginhistoryRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<LoginhistoryListResponseDto> findAllDesc(){
        return loginhistoryRepository.findAllDesc().stream().map(Loginhistory ->
                        new LoginhistoryListResponseDto(Loginhistory.getId(), Loginhistory.getEmail(),
                                Loginhistory.getIp(), Loginhistory.getRole(), Loginhistory.getValue(), Loginhistory.getModifiedDate())).
                collect(Collectors.toList());
    }

}
