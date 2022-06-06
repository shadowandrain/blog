package com.zdy.blog.controller;

import com.zdy.blog.model.Blog;
import com.zdy.blog.model.Users;
import com.zdy.blog.model.UsersInfo;
import com.zdy.blog.service.AdminService;
import com.zdy.blog.service.LoginAndRegisterService;
import com.zdy.blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
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
     * 未登录拦截跳转的页面
     */
    @RequestMapping("/interceptor")
    @ResponseBody
    public Object interceptor(){
        return "请登录后在进行访问";
    }

    /**
     * 跳转主页面
     */
    @RequestMapping("/index")
    public String index(){
        return "login/index";
    }

    /**
     * 跳转登录页面
     * @return
     * 不好看，不要了，有时间再改
     */
    @RequestMapping("/loginPage")
    public String login(){
        return "login/loginPage";
    }

    /**
     * 跳转注册页面
     * @return
     * 不好看，不要了，有时间再改
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
     * 旧表，不用了
     * @param username
     * @param password
     * @param nowPage
     * @param model
     * @param request
     * @return
     */
    /*@RequestMapping("/userLogin")
    public String UserLogin(String username, String password,int nowPage, Model model,HttpServletRequest request) {
        String newPassword = MD5Util.getMD5(password);
        int result = lgService.selectUser(username, newPassword);
        if (result != 0) {
            String power = lgService.selectPower(username, newPassword);
            Users user = new Users();
            user.setUsername(username);
            user.setPower(power);
            model.addAttribute("username",username);
            model.addAttribute("password",password);
            model.addAttribute("power",power);
            request.getSession().setAttribute("user",user);
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
                return "user/userPage";
            }
        } else {
            return "login/indexLoginInfoError";
        }
        return "";
    }*/

    /**
     * 用户登录
     * @param username
     * @param password
     * @param nowPage
     * @param model
     * @param request
     * 新表
     * @return
     */
    @RequestMapping("/userLogin")
    public String UserLogin(String username, String password,int nowPage, Model model,HttpServletRequest request) {
        String newPassword = MD5Util.getMD5(password);
        int result = lgService.selectUser(username, newPassword);
        if (result != 0) {
            String power = lgService.selectPower(username, newPassword);
            UsersInfo user = new UsersInfo();
            user.setUsername(username);
            user.setPower(power);
            model.addAttribute("username",username);
            model.addAttribute("password",password);
//            model.addAttribute("power",power);
            request.getSession().setAttribute("user",user);
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
                return "user/userPage";
            }
        } else {
            return "login/indexLoginInfoError";
        }
        return "";
    }

    /**
     * 用户注册
     * 旧表，不用了
     * @param username
     * @param password
     * @param email
     * @param //power
     * @return
     * 当前注册页面没给身份选择,不要power了
     */
    /*@RequestMapping("/userRegister")
//    public String userRegister(String username ,String password,String email,String power){
    public String userRegister(String username ,String password,String email){
        String newPassword = MD5Util.getMD5(password);
        Users users = new Users();
        int result = 0;
        users.setUsername(username);
        users.setPassword(newPassword);
        users.setEmail(email);
//        users.setPower(power);
        //查询是否以注册
        int rs = lgService.selectUser(username, newPassword);
        if(rs != 0){
            return "login/indexRegisterError";
        }else{
            result = lgService.inputUser(users);
            if(result != 0){
                return "login/indexRegisterSuccess";
            }
        }
        return "";
    }*/

    /**
     * 用户注册
     * @param username
     * @param password
     * @param email
     * @param //power
     * @return
     * 新表
     */
    @RequestMapping("/userRegister")
    public String userRegister(String username ,String password,String email){
        String newPassword = MD5Util.getMD5(password);
        UsersInfo users = new UsersInfo();
        int result = 0;
        users.setUsername(username);
        users.setPassword(newPassword);
        users.setEmail(email);
        //查询是否以注册
        int rs = lgService.selectUser(username, newPassword);
        if(rs != 0){
            return "login/indexRegisterError";
        }else{
            result = lgService.inputUser(users);
            if(result != 0){
                return "login/indexRegisterSuccess";
            }
        }
        return "";
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
        UsersInfo users = new UsersInfo();
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
