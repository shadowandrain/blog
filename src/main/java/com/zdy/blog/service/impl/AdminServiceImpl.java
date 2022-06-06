package com.zdy.blog.service.impl;

import com.zdy.blog.mapper.BlogMapper;
import com.zdy.blog.mapper.ClassMapper;
import com.zdy.blog.mapper.UsersMapper;
import com.zdy.blog.model.*;
import com.zdy.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private ClassMapper classMapper;


    @Override
    public List<UsersInfo> getAllUser() {
        return usersMapper.selectAllUsers();
    }

    @Override
    public int updataInfo(Users users) {
        return usersMapper.updateByUserNameAndPowerSelective(users);
    }

    @Override
    public int delectUserInfo(String username, String power) {
        return usersMapper.deleteByUserNameAndPower(username, power);
    }

    /**
     * 表连接查询
     * @return
     */
    @Override
    public List<Blog> getAllBlog() {
        return blogMapper.selectAllTwo();
    }

    @Override
    public List<Blog> blogTitleSelect(String select_title) {
        return blogMapper.selectByTitle(select_title);
    }

    @Override
    public int deleteBlogInfo(Integer id) {
        return blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBlogInfo(Blog blog) {
        return blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public int insertBlog(Blog blog) {
        return blogMapper.insert(blog);
    }

    @Override
    public List<ClassBlog> getAllBlogClass() {
        return classMapper.selectAll();
    }

    @Override
    public int updateBlogClassInfo(ClassBlog classBlog) {
        return classMapper.updateByPrimaryKeySelective(classBlog);
    }

    @Override
    public int deleteBlogClass(Integer id) {
        return classMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertBlogClass(ClassBlog classBlog) {
        return classMapper.insert(classBlog);
    }

    @Override
    public List<ClassBlog> selectAllClassNameAndId() {
        return classMapper.selectALlClassNameAndId();
    }

    @Override
    public int getAllTotal() {
        return blogMapper.selectAllTotle();
    }

    @Override
    public List<Blog> getPageSizeBlog(int pageNo,int pageSize) {
        return blogMapper.selectPageSizeBlog(pageNo,pageSize);
    }

    @Override
    public int getAllTotalTwo(String select_title) {
        return blogMapper.selectAllTotleTwo(select_title);
    }
}
