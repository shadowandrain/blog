package com.zdy.blog.service.impl;

import com.zdy.blog.mapper.UsersMapper;
import com.zdy.blog.model.UsersInfo;
import com.zdy.blog.service.PreInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreInfoImpl implements PreInfo {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Integer updatePreInfo(UsersInfo usersInfo) {
        return usersMapper.updatePreInfoByPrimayrKey(usersInfo);
    }
}
