package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUser() throws Exception {
        return userMapper.getUser();
    }
    //根据id删除用户
    @Override
    public void deleteUser(int id) throws Exception {
        userMapper.deleteUser(id);
    }
    //新增用户
    @Override
    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }
}