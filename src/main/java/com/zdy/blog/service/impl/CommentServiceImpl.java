package com.zdy.blog.service.impl;

import com.zdy.blog.mapper.CommentMapper;
import com.zdy.blog.model.Comment;
import com.zdy.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getAllComment(Integer id) {
        return commentMapper.selectByBlogId(id);
    }

    @Override
    public int deleteComment(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertComment(Comment comment) {
        commentMapper.insert(comment);
    }

}
