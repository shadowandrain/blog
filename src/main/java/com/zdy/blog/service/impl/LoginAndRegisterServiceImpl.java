package com.zdy.blog.service.impl;

import com.zdy.blog.mapper.BlogMapper;
import com.zdy.blog.mapper.UsersMapper;
import com.zdy.blog.model.Blog;
import com.zdy.blog.model.Users;
import com.zdy.blog.model.UsersInfo;
import com.zdy.blog.service.LoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginAndRegisterServiceImpl implements LoginAndRegisterService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int selectUser(String username, String password) {
        return usersMapper.selectByPrimaryInfo(username,password);
    }

    @Override
    public String selectPower(String username, String password) {
        return usersMapper.selectByPrimaryPower(username,password);
    }

    @Override
    public int inputUser(UsersInfo users) {
        return usersMapper.insertSelective(users);
    }

    @Override
    public int updataPassword(UsersInfo users) {
//        return usersMapper.updateByUserNameAndPowerSelective(users);
        return 1;
    }

    @Override
    public List<Blog> selectBlogAll() {
        return blogMapper.selectAll();
    }
}
