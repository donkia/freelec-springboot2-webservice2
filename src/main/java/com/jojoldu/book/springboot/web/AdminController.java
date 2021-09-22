package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.loginhistory.LoginhistroyService;
import com.jojoldu.book.springboot.web.dto.LoginhistoryListResponseDto;
import com.jojoldu.book.springboot.web.dto.LoginhistoryRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final LoginhistroyService loginhistroyService;

    @GetMapping("/admin/history")
    public String loginHistory(Model model){

        List<LoginhistoryListResponseDto> dto = loginhistroyService.findAllDesc();
        model.addAttribute("dto", dto);
        System.out.println("dto : " + dto );
        return "/admin/login-history";
    }

}
