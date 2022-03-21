package com.zdy.blog.controller;

import com.zdy.blog.service.UserLoginService;
import com.zdy.blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class Login {

    @Autowired
    private UserLoginService userLoginService;

    //Users result;

    //@RequestMapping("/login")
    public String login(){
        return "login";
    }

    /*@GetMapping("/userLogin/{username}/{password}")
    public String UserLogin(@PathVariable("username") String username,
                        @PathVariable("password") String password, Model model) {
        result = userLoginService.selectUser(username, password);
        if (result.getUsername() != null && result.getPassword() != null) {
            if (result.getPower() == "admin") {
                return "admin";
            }
            if (result.getPower() == "user") {

                return "user";
            } else {
                return "loginErrorPower";
            }
        } else {
            return "loginError";
        }
    }*/

    //@RequestMapping("/userLogin")
    public String UserLogin(String username, String password) {
        String newPassword = MD5Util.getMD5(password);
        int result = userLoginService.selectUser(username, newPassword);
        if (result != 0) {
            String power = userLoginService.selectPower(username, newPassword);
            if ("admin".equals(power)) {
                return "admin";
            }else if("user".equals(power)) {
                return "user";
            } else {
                return "loginErrorPower";
            }
        } else {
            return "loginInfoError";
        }
    }

    //@RequestMapping("/updataPassword")
    public String updataPassword(String username,String password){

        return "updataPassword";
    }
}
