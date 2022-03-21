package com.zdy.blog.controller;

import com.zdy.blog.model.Users;
import com.zdy.blog.service.RegisterService;
import com.zdy.blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class Register {

    @Autowired
    private RegisterService registerService;

    //@RequestMapping("/register")
    public String register(){
        return "register";
    }

    //@RequestMapping("/userRegister")
    public String userRegister(String username ,String password,String email,String power){
        String newPassword = MD5Util.getMD5(password);
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(newPassword);
        users.setEmail(email);
        users.setPower(power);
        int result = registerService.inputUser(users);
        if(result != 0){
            return "registerSuccess";
        }else{
            return "registerError";
        }
    }
}
