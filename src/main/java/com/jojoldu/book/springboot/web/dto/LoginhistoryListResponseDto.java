package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.loginhistory.Loginhistory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class LoginhistoryListResponseDto {

    private Long id;
    private String email;
    private String ip;
    private String role;
    private String value;
    private LocalDateTime modifiedDate;


    public LoginhistoryListResponseDto(Long id, String email, String ip, String role, String value, LocalDateTime modifiedDate) {
        this.id = id;
        this.email = email;
        this.ip = ip;
        this.role = role;
        this.value = value;
        this.modifiedDate = modifiedDate;
    }

}
