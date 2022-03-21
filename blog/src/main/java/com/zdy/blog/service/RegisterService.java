package com.zdy.blog.service;

import com.zdy.blog.model.Users;

public interface RegisterService {
    /**
     * 添加用户至数据库
     * @return
     */
    int inputUser(Users users);
}
