package com.zdy.blog.service;

import com.zdy.blog.model.Blog;
import com.zdy.blog.model.Users;

import java.util.List;

public interface LoginAndRegisterService {

    /**
     * 根据用户账号密码确认用户是否登录
     * @param username
     * @param password
     * @return
     */
    int selectUser(String username, String password);

    /**
     * 根据账号密码确认账号权限
     * @param username
     * @param password
     * @return 用户权限
     */
    String selectPower(String username, String password);

    /**
     * 添加用户至数据库
     * @return
     */
    int inputUser(Users users);

    /**
     * 修改密码
     * @param users
     * @return
     */
    int updataPassword(Users users);

    /**
     * 获取博客信息
     * @return
     */
    List<Blog> selectBlogAll();
}
