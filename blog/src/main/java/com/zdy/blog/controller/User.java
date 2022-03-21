package com.zdy.blog.controller;

import com.zdy.blog.model.Blog;
import com.zdy.blog.model.Comment;
import com.zdy.blog.service.AdminService;
import com.zdy.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class User {

    @Autowired
    private CommentService commentService;


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
     * 通过Id添加评论信息
     * @param model
     */
    /*@RequestMapping("/comment")
    public void comment(Integer id,String context,String username, Model model){
        Comment comment = new Comment();
        comment.setContext(context);
        comment.setCreatedtime(new Date());
        comment.setId(id);
        comment.setUsername(username);
        commentService.insertComment(comment);
    }*/


    @RequestMapping("/comment")
    public String comment(Integer blogid,Integer nowPage,String username,String password,Model model) {
        List<Comment> commentList = commentService.getAllComment(blogid);
        model.addAttribute("commentList",commentList);
        model.addAttribute("blogid",blogid);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        model.addAttribute("nowPage",nowPage);
        return "user/comment";
    }

    @RequestMapping("/insertComment")
    public String insertComment(String context,Integer blogid,String username,Integer nowPage,Model model){
        Comment comment = new Comment();
        comment.setContext(context);
        comment.setCreatedtime(new Date());
        comment.setBlogid(blogid);
        comment.setUsername(username);
        commentService.insertComment(comment);

        List<Comment> commentList = commentService.getAllComment(blogid);
        model.addAttribute("commentList",commentList);
        model.addAttribute("blogid",blogid);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("username",username);
        return "user/comment";
    }

    @RequestMapping("/blogPage")
    public String blogPage(Integer nowPage,String username,String password,Model model){
        totalSize = adminService.getAllTotal();
        pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
        List<Blog> blogList = adminService.getPageSizeBlog((nowPage-1) * pageSize,pageSize);
        model.addAttribute("blogList",blogList);
        model.addAttribute("totalSize",totalSize);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        model.addAttribute("pageCount",pageCount);
        return "user/userPage";
    }


}
