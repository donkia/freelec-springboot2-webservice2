package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.comments.Comments;
import com.jojoldu.book.springboot.service.Comments.CommentsService;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.CommentsListResponseDto;
import com.jojoldu.book.springboot.web.dto.CommentsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.h2.engine.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    private final CommentsService commentsService;
    /*
    @GetMapping("/")
    public String index() {
        return "index";
    }
*/
    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user){
        model.addAttribute("userName", user.getName());
        return "posts-save";
    }

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
        System.out.println("posts : " + postsService.findAllDesc());
        if(user!= null)
            model.addAttribute("userName", user.getName());
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String PostsUpdate(@PathVariable Long id, Model model){

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        try{
            List<CommentsListResponseDto> dto1 = commentsService.findAllDesc(id);
            System.out.println("dto1 : " + dto1);

            model.addAttribute("Comments", dto1);
            if(!dto1.isEmpty()){
                for(int i = 0; i < dto1.size(); i++){
                    System.out.println("dto2 : " + dto1.get(i).toString());
                }
            }


        }catch (Exception e){
            System.out.println("e : " + e);
        }

        return "posts-update";
    }


}

