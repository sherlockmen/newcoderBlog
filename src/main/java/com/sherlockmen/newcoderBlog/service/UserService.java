package com.sherlockmen.newcoderBlog.service;

import com.sherlockmen.newcoderBlog.dao.UserMapper;
import com.sherlockmen.newcoderBlog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
