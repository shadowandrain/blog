package com.zdy.blog.controller;

import com.zdy.blog.model.Blog;
import com.zdy.blog.model.Users;
import com.zdy.blog.service.AdminService;
import com.zdy.blog.service.LoginAndRegisterService;
import com.zdy.blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/login")
@Controller
public class LoginAndRegister {

    @Autowired
    private LoginAndRegisterService lgService;

    @Autowired
    private AdminService adminService;

    int result = 0;

    //总记录条数
    int totalSize = 0;

    //每页记录条数
    int pageSize = 4;

    //总页数
    int pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;

    //当前页数
    int nowPage = 1;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/loginPage")
    public String login(){
        return "login/loginPage";
    }

    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping("/registerPage")
    public String register(){
        return "login/registerPage";
    }

    /**
     * 跳转修改密码页面
     * @return
     */
    @RequestMapping("/updataPasswordPage")
    public String updataPasswordPage(String username, String power, Model model){
        model.addAttribute("username",username);
        model.addAttribute("power",power);
        return "admin/updataPasswordPage";
    }

    @RequestMapping("/adminPage")
    public String adminPage(){
        return "admin/adminPage";
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/userLogin")
    public String UserLogin(String username, String password, Model model) {
        String newPassword = MD5Util.getMD5(password);
        int result = lgService.selectUser(username, newPassword);
        if (result != 0) {
            String power = lgService.selectPower(username, newPassword);
            Users user = new Users();
            user.setUsername(username);
            user.setPower(power);
//            model.addAttribute("user",user);
            model.addAttribute("username",username);
            model.addAttribute("password",password);
            model.addAttribute("power",power);
            if ("admin".equals(power)) {
                return "admin/adminPage";
            }else if("user".equals(power)) {
                totalSize = adminService.getAllTotal();
                pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
                List<Blog> blogList = adminService.getPageSizeBlog((nowPage-1) * pageSize,pageSize);
                model.addAttribute("blogList",blogList);
                model.addAttribute("totalSize",totalSize);
                model.addAttribute("pageSize",pageSize);
                model.addAttribute("nowPage",nowPage);
                model.addAttribute("pageCount",pageCount);
                /*List<Blog> blogList = lgService.selectBlogAll();
                model.addAttribute("blogList",blogList);*/
                return "user/userPage";
            } else {
                return "login/loginErrorPower";
            }
        } else {
            return "login/loginInfoError";
        }
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @param email
     * @param power
     * @return
     */
    @RequestMapping("/userRegister")
    public String userRegister(String username ,String password,String email,String power){
        String newPassword = MD5Util.getMD5(password);
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(newPassword);
        users.setEmail(email);
        users.setPower(power);
        int result = lgService.inputUser(users);
        if(result != 0){
            return "login/registerSuccess";
        }else{
            return "login/registerError";
        }
    }

    /**
     * 修改密码
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/updataPassword")
    public String updataPassword(String username,String password,String power){
        String newPassword = MD5Util.getMD5(password);
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(newPassword);
        users.setPower(power);
        int result = lgService.updataPassword(users);
        if(result != 0){
            return "login/loginPage";
        }else {
            return "admin/updataPasswordError";
        }
    }


}
