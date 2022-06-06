package com.zdy.blog.controller;

import com.zdy.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class Comment {

    @Autowired
    private CommentService commentService;

    int result = 0;

    /**
     * 根据博文id获取相应博文评论
     * @param blogid 博文Id
     * @param model
     * @return
     */
    @RequestMapping("/blogComment")
    public String blogComment(Integer blogid,Model model){
        List<com.zdy.blog.model.Comment> commentList = commentService.getAllComment(blogid);
        model.addAttribute("commentList",commentList);
        return "admin/blogComment";
    }

    /**
     * 根据评论Id删除评论
     * @param commentid 评论Id(评论主键值)
     * @param model
     * @return
     */
    @RequestMapping("/deleteBlogComment")
    public String deleteBlogComment(Integer commentid,Integer blogid,Model model){
        result =  commentService.deleteComment(commentid);
        if(result != 0){
            List<com.zdy.blog.model.Comment> commentList = commentService.getAllComment(blogid);
            model.addAttribute("commentList",commentList);
            return "admin/blogComment";
        }else{
            return "admin/deleteBlogCommentError";
        }
    }
}
