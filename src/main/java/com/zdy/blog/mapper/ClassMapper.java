package com.zdy.blog.mapper;

import com.zdy.blog.model.ClassBlog;
import com.zdy.blog.model.Comment;

import java.util.List;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassBlog record);

    int insertSelective(ClassBlog record);

    ClassBlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassBlog record);

    int updateByPrimaryKey(ClassBlog record);

    List<ClassBlog> selectAll();

    List<ClassBlog> selectALlClassNameAndId();
}