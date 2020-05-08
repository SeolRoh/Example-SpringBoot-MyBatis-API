package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.entity.Users;
import com.example.springbootmybatis.exeption.UserNotFoundException;
import com.example.springbootmybatis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    UserService service;

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        List<Users> list = service.getAllUsers();
        return list;
    }

    @GetMapping("/users/{id}")
    public Users getUsersById(@PathVariable String id){
        Users user = service.getUserById(id);
        if(user ==null){
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }
//    @PostMapping("/users")
//    public ResponseEntity<Users> createUser(@RequestBody Users user){
//        int createduser = service.createUser(user);
//
//    }
}
