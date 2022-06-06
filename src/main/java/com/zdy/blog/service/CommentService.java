package com.zdy.blog.service;

import com.zdy.blog.model.Comment;

import java.util.Date;
import java.util.List;

public interface CommentService {

    /**
     * 根据博文Id查看相应评论
     * @return
     */
    List<Comment> getAllComment(Integer id);


    /**
     * 根据评论Id删除评论
     * @param id 评论Id
     * @return
     */
    int deleteComment(Integer id);

    /**
     * 通过Id添加评论信息
     * @param comment
     */
    void insertComment(Comment comment);
}
