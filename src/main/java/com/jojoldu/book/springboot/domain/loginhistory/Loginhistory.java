package com.jojoldu.book.springboot.domain.loginhistory;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Loginhistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ip;

    private String role;

    private String email;

    private String value;

    @Builder
    public Loginhistory(Long id, String ip, String role, String email, String value) {
        this.id = id;
        this.ip = ip;
        this.role = role;
        this.email = email;
        this.value = value;
    }
}
