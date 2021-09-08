package com.jojoldu.book.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "donkia96@gmail.com";

    public void mailSend(){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("donkia96@gmail.com");
        message.setFrom("donkia96@gmail.com");
        message.setSubject("제목");
        message.setText("내용");
        try{
            mailSender.send(message);

        }catch(Exception e){
            System.out.println("e : " + e);
        }

    }
}
