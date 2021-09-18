package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.comments.Comments;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.service.Comments.CommentsService;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.*;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import lombok.RequiredArgsConstructor;
import org.h2.engine.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        int totCnt = postsService.findAllDesc().size();
        //model.addAttribute("posts", postsService.findAllDesc());
        model.addAttribute("posts", postsService.pagingfindAllDesc(0));


        model.addAttribute("previous", null);
        if(0 < totCnt / 10)
            model.addAttribute("next", 1);

        System.out.println("posts1 : " + postsService.findAllDesc());
        System.out.println("totalCnt : " + postsService.findAllDesc().size());


        if(user!= null)
            model.addAttribute("userName", user.getName());
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String PostsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user){

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        model.addAttribute("userName", user.getName());

        postsService.updateHit(id);

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

    @GetMapping("/get/search")
    //public  List<PostsListResponseDto> getSearch(@RequestParam("search") String search, Model model, @LoginUser SessionUser user){
    public  String  getSearch(@RequestParam("search") String search,
            @RequestParam("type") String type, Model model, @LoginUser SessionUser user){

        System.out.println("requestDto : " + search +" , type : " + type);
        List<PostsListResponseDto> posts = null;
        // 아무 데이터도 안넘어왔을 때
        if(search == null){
            posts = postsService.findAllDesc();
        }
        else {
            if(type.equals("content"))
                posts = postsService.searchContentAllDesc(search);
            else if(type.equals("title"))
                posts = postsService.searchTitleAllDesc(search);
            else if(type.equals("author"))
                posts = postsService.searchAuthorAllDesc(search);
        }

        model.addAttribute("posts", posts);

        if(user!= null)
            model.addAttribute("userName", user.getName());
        System.out.println("posts2 : " + posts.toString());

        return "index";
    }


    @GetMapping("/pagelist")
    public String pagelist(@RequestParam("num") long num, Model model, @LoginUser SessionUser user){

        int totCnt = postsService.findAllDesc().size();
        model.addAttribute("posts", postsService.pagingfindAllDesc(num*10));
        System.out.println("paging posts(" + num+") : "  + postsService.pagingfindAllDesc(num));
        model.addAttribute("num", num);

        if(num > 0){
            model.addAttribute("previous", num-1);
        }
        else if(num <= 0)
            model.addAttribute("previous", null);

        if(num < totCnt/ 10)
            model.addAttribute("next", num+1);
        else
            model.addAttribute("next", null);


        if(user!= null)
            model.addAttribute("userName", user.getName());

        return "index";
    }

}

