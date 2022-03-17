package com.wonjuyeon.book.postservice;

import com.wonjuyeon.book.postservice.web.config.auth.LoginUser;
import com.wonjuyeon.book.postservice.web.config.auth.dto.SessionUser;
import com.wonjuyeon.book.postservice.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostsService postsService;

    @GetMapping("/")
    public String home(Model model, @LoginUser SessionUser user){

        if( user != null ){
            model.addAttribute("name", user.getName());
        }
        return "home";
    }
}
