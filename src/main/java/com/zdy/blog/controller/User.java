package com.zdy.blog.controller;

import com.zdy.blog.model.Blog;
import com.zdy.blog.model.Comment;
import com.zdy.blog.model.UsersInfo;
import com.zdy.blog.service.AdminService;
import com.zdy.blog.service.CommentService;
import com.zdy.blog.service.PreInfo;
import com.zdy.blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class User {

    @Autowired
    private CommentService commentService;


    @Autowired
    private AdminService adminService;

    @Autowired
    private PreInfo preInfo;

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
     * 通过Id添加评论信息
     * @param model
     */
    @RequestMapping("/comment")
    public String comment(Integer blogId,String username,String blogTitle,String blogTime,String blogContext,Model model) {
        List<Comment> commentList = commentService.getAllComment(blogId);
        model.addAttribute("commentList",commentList);
        model.addAttribute("blogId",blogId);
        model.addAttribute("username",username);
        model.addAttribute("blogTitle",blogTitle);
        model.addAttribute("blogTime",blogTime);
        model.addAttribute("blogContext",blogContext);
        return "user/comment";
    }

    /**
     * 提交评论
     * @param context
     * @param blogId
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("/insertComment")
    public String insertComment(String context,Integer blogId,String username,String blogTitle,String blogTime,String blogContext,Model model){
        Comment comment = new Comment();
        comment.setContext(context);
        comment.setCreatedtime(new Date());
        comment.setBlogid(blogId);
        comment.setUsername(username);
        commentService.insertComment(comment);
        List<Comment> commentList = commentService.getAllComment(blogId);
        model.addAttribute("commentList",commentList);
        model.addAttribute("blogId",blogId);
        model.addAttribute("username",username);
        model.addAttribute("blogTitle",blogTitle);
        model.addAttribute("blogTime",blogTime);
        model.addAttribute("blogContext",blogContext);
        return "user/comment";
    }

    /**
     * 分页按钮查询跳转
     * @param nowPage
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/blogPage")
    public String blogPage(Integer nowPage,String username,String password,Model model){
        totalSize = adminService.getAllTotal();
        //pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
        //现由layui内部通过总记录条数和没页数计算
        List<Blog> blogList = adminService.getPageSizeBlog((nowPage-1) * pageSize,pageSize);
        model.addAttribute("blogList",blogList);
        model.addAttribute("totalSize",totalSize);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
//        model.addAttribute("pageCount",pageCount);
        return "user/userPage";
    }

    /**
     * 进入个人信息页面
     * addTime 2022/5/29 詹冬园
     * @return
     */
    @RequestMapping("/perInfoPage")
    public String perInfoPage(String username,String password,Model model){
        model.addAttribute("username",username);

        model.addAttribute("password",password);
        //之后再添加查询邮箱并发送到前端
        model.addAttribute("email","test@test.com");
        return "user/perInfoPage";
    }

    /**
     * 进入发布博客页面
     * @param username
     * @param model
     * addTime 2022/5/29 詹冬园
     * @return
     */
    @RequestMapping("/putBlogPage")
    public String putBlogPage(String username,Model model){
        model.addAttribute("username",username);
        return "user/putBlogPage";
    }

    /**
     * 修改个人信息
     * @param username
     * @param password
     * @param email
     * @param phone
     * @param qq
     * @param address
     * @param birth
     * @param sex
     * @param model
     * addTime 2022/5/29 詹冬园
     * @return
     */
    @RequestMapping("/updatePerInfo")
    public String updatePerInfo(
            String username,String password,String email,String phone,String qq,String address,String birth,String sex,Model model
    ){
        Date birthday = null;
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UsersInfo usersInfo = new UsersInfo();
        String newPassword = MD5Util.getMD5(password);
        usersInfo.setUsername(username);
        usersInfo.setPassword(newPassword);
        usersInfo.setEmail(email);
        usersInfo.setPhone(phone);
        usersInfo.setQq(qq);
        usersInfo.setAddress(address);
        usersInfo.setBirth(birthday);
        usersInfo.setSex(sex);
        int result = preInfo.updatePreInfo(usersInfo);
        if(result != 0){
            return "user/perInfoPageSuccess";
        }
        return "login/index";
//        model.addAttribute();
    }

    /**
     * 提交博客数据
     * @param title
     * @param author
     * @param classId
     * @param content
     * @param model
     * @return
     */
    @RequestMapping("/putBlog")
    public String putBlog(String title,String author,Integer classId,String content,Model model){
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setAuthor(author);
        blog.setClassid(classId);
        blog.setContext(content);
        blog.setCreatedtime(new Date());
        result = adminService.insertBlog(blog);
        if(result != 0){
            model.addAttribute("username",author);
            return "user/putBlogSuccess";
        }

        return "user/putBlogPage";
    }

}
