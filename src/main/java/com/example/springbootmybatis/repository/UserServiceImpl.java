package com.example.springbootmybatis.repository;


import com.example.springbootmybatis.entity.Users;
import com.example.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired // 그러면 Usermapper랑 같은 클래스를 프레임워크가 찾아와 알아서 주입시켜 mapper 값을 사용한다.
    UserMapper mapper;

    @Override
    public List<Users> getAllUsers() {
        return mapper.selectAllUsers();
    }

    @Override
    public Users getUserById(String id) {
        return mapper.selectUserById(id);
    }

    @Override
    public int createUser(Users user) {
        return mapper.insertUser(user);
    }

    @Override
    public int modifyUser(Users user) {
//        return mapper.updateUser(user);
        //update > delete > insert
        mapper.deleteUser(user.getId());
        mapper.insertUser(user);
        return 1;
    }

    @Override
    public int removeUser(String id) {
        return mapper.deleteUser(id);
    }
}
