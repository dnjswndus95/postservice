package com.wonjuyeon.book.postservice.web.controller;

import com.wonjuyeon.book.postservice.domain.posts.Posts;
import com.wonjuyeon.book.postservice.web.dto.PostsResponseDto;
import com.wonjuyeon.book.postservice.web.dto.PostsSaveRequestDto;
import com.wonjuyeon.book.postservice.web.dto.PostsUpdateDto;
import com.wonjuyeon.book.postservice.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsService postsService;

    @GetMapping("/post")
    public String postList(Model model){
        List<PostsResponseDto> postList = postsService.findAllDto();
        model.addAttribute("postList", postList);
        return "posts/postList";
    }

    @GetMapping("/post/save")
    public String saveForm(Model model){
        model.addAttribute("postForm", new PostsSaveRequestDto());
        return "posts/createPostForm";
    }

    @PostMapping("/post/save")
    public String save(@Valid PostsSaveRequestDto dto, BindingResult result){
        if(result.hasErrors())
            return "posts/createPostForm";

        postsService.save(dto);

        return "redirect:/";
    }

    @GetMapping("/post/{id}/edit")
    public String editForm(@PathVariable Long id){
       // postsService.find
        return " ";
    }
}
