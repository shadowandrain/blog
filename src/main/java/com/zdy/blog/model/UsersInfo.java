package com.zdy.blog.model;

import lombok.Data;

import java.util.Date;

@Data
public class UsersInfo {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String qq;
    private String address;
    private Date birth;
    private String sex;
    private String power;
}
