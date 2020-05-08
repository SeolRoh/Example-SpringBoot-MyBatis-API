package com.example.springbootmybatis.service;

import com.example.springbootmybatis.entity.Posts;

import java.util.List;

public interface PostService {
    List<Posts> getAllPosts();
    Posts getPostById(int id);
    int createPost(Posts post);
    int modifyPost(Posts post);
    int removePost(int id);
}
