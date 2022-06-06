package com.zdy.blog.service.impl;

import com.zdy.blog.mapper.UsersMapper;
import com.zdy.blog.model.Users;
import com.zdy.blog.model.UsersInfo;
import com.zdy.blog.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int inputUser(UsersInfo users) {
        return usersMapper.insert(users);
    }
}
