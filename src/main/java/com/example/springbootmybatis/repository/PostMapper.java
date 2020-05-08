package com.example.springbootmybatis.repository;

import com.example.springbootmybatis.entity.Posts;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostMapper {
    List<Posts> selectAllPosts();
    Posts selectPostById(int id);
    int insertPost(Posts post);
    int updatePost(Posts post);
    int deletePost(int id);
}
