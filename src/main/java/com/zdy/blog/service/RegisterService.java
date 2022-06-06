package com.zdy.blog.service;

import com.zdy.blog.model.Users;
import com.zdy.blog.model.UsersInfo;

public interface RegisterService {
    /**
     * 添加用户至数据库
     * @return
     */
    int inputUser(UsersInfo users);
}
