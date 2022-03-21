package com.zdy.blog.service.impl;

import com.zdy.blog.mapper.UsersMapper;
import com.zdy.blog.model.Users;
import com.zdy.blog.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int selectUser(String username, String password) {
        return usersMapper.selectByPrimaryInfo(username,password);
    }

    @Override
    public String selectPower(String username, String password) {
        return usersMapper.selectByPrimaryPower(username,password);
    }
}
