package com.zdy.blog.mapper;

import com.zdy.blog.model.Users;
import com.zdy.blog.model.UsersInfo;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(String username);

    int deleteByUserNameAndPower(String username,String power);

    int insert(UsersInfo record);

    int insertSelective(UsersInfo record);

    UsersInfo selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(UsersInfo record);

    int updateByUserNameAndPowerSelective(Users record);

    int updateByPrimaryKey(UsersInfo record);

    int selectByPrimaryInfo(String username, String password);

    String selectByPrimaryPower(String username, String password);

    List<UsersInfo> selectAllUsers();

    int updatePreInfoByPrimayrKey(UsersInfo usersInfo);
}