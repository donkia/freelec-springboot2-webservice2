package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.loginhistory.Loginhistory;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginhistoryRequestDto {

    private String email;
    private String ip;
    private String role;
    private String value;

    public LoginhistoryRequestDto(String email, String ip, String role, String value) {
        this.email = email;
        this.ip = ip;
        this.role = role;
        this.value = value;
    }

    public Loginhistory toEntity(){
        return Loginhistory.builder()
                .ip(ip)
                .email(email)
                .role(role)
                .value(value)
                .build();
    }
}
