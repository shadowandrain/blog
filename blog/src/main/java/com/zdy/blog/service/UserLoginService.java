package com.zdy.blog.service;

import com.zdy.blog.model.Users;
import org.springframework.stereotype.Service;

public interface UserLoginService {

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

}
