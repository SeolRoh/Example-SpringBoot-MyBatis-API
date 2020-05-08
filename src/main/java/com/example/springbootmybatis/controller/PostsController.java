package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.entity.Posts;
import com.example.springbootmybatis.exeption.UserNotFoundException;
import com.example.springbootmybatis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostsController {
    @Autowired
    PostService service;

    @GetMapping("/posts")
    public List<Posts> getAllPosts(){
        List<Posts> post = service.getAllPosts();
        return post;
    }

    @GetMapping("/posts/{id}")
    public Posts getPostsById(@PathVariable int id){
        Posts post = service.getPostById(id);
        if(post == null){
            throw new UserNotFoundException("id-" + id);
        }
        return post;
    }
}
