package com.tomek.zadanie.controller;

import com.tomek.zadanie.dto.Post;
import com.tomek.zadanie.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @Autowired
    @SuppressWarnings("unused")
    private PostService postService;

    @GetMapping("/{id}")
    @SuppressWarnings("unused")
    public String getPost(@PathVariable(name="id", required=false) String id, Model model) {
        try {
            Post post = postService.getPost(id);
            model.addAttribute("userId", post.getUserId());
            model.addAttribute("id", post.getId());
            model.addAttribute("title", post.getTitle());
            model.addAttribute("body", post.getBody());
        }catch (Exception e){
            e.printStackTrace();
        }

        return "index"; //view
    }

    @GetMapping("/")
    @SuppressWarnings("unused")
    public String getDefaultPost(Model model) {
        try {
            Post post = postService.getPost("1");
            model.addAttribute("userId", post.getUserId());
            model.addAttribute("id", post.getId());
            model.addAttribute("title", post.getTitle());
            model.addAttribute("body", post.getBody());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index"; //view
    }
}