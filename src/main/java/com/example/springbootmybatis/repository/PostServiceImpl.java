package com.example.springbootmybatis.repository;

import com.example.springbootmybatis.entity.Posts;
import com.example.springbootmybatis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper mapper;

    @Override
    public List<Posts> getAllPosts() {
        return mapper.selectAllPosts();
    }

    @Override
    public Posts getPostById(int id) {
        return mapper.selectPostById(id);
    }

    @Override
    public int createPost(Posts post) {
        return mapper.insertPost(post);
    }

    @Override
    public int modifyPost(Posts post) {
        mapper.deletePost(post.getId());
        mapper.insertPost(post);
        return 1;
    }

    @Override
    public int removePost(int id) {
        return mapper.deletePost(id);
    }
}
