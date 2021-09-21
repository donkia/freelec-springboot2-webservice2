package com.jojoldu.book.springboot.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerErrorController implements ErrorController {

    @RequestMapping(value="/error")
    public String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null){
            int statusCode = Integer.valueOf(status.toString());
            System.out.println("error 페이지 : " + statusCode);
            if(statusCode == HttpStatus.NOT_FOUND.value()){
                return "error/404";
            }
        }
        System.out.println("에러페이지 호출");
        return "error/500";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
