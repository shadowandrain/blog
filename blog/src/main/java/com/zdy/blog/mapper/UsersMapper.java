package com.zdy.blog.mapper;

import com.zdy.blog.model.Users;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(String username);

    int deleteByUserNameAndPower(String username,String power);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Users record);

    int updateByUserNameAndPowerSelective(Users record);

    int updateByPrimaryKey(Users record);

    int selectByPrimaryInfo(String username, String password);

    String selectByPrimaryPower(String username, String password);

    List<Users> selectAllUsers();
}