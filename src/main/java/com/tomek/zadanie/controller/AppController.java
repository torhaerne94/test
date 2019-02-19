package com.tomek.zadanie.controller;

import com.tomek.zadanie.pojo.Post;
import com.tomek.zadanie.service.GetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @Autowired
    @SuppressWarnings("unused")
    private GetRequest getRequest;

    @GetMapping("/{id}")
    @SuppressWarnings("unused")
    public String getPost(@PathVariable(name="id", required=false) String id, Model model) {
        Post post = getRequest.method("https://jsonplaceholder.typicode.com/posts/"+id);
        model.addAttribute("userId", post.getUserId());
        model.addAttribute("id", post.getId());
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());

        return "index"; //view
    }

    @GetMapping("/")
    @SuppressWarnings("unused")
    public String getDefaultPost(Model model) {
        Post post = getRequest.method("https://jsonplaceholder.typicode.com/posts/1");
        model.addAttribute("userId", post.getUserId());
        model.addAttribute("id", post.getId());
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());

        return "index"; //view
    }
}