package com.zdy.blog.service;

import com.zdy.blog.model.*;

import java.util.Date;
import java.util.List;

public interface AdminService {
    /**
     * 获取所有用户信息
     * @return
     */
    List<UsersInfo> getAllUser();

    /**
     * 修改用户数据
     * @return
     */
    int updataInfo(Users users);

    /**
     * 删除用户数据
     * @param username
     * @param power
     * @return
     */
    int delectUserInfo(String username,String power);

    /**
     * 获取所有博文信息
     * @return
     */
    List<Blog> getAllBlog();

    /**
     * 根据博文标题获取博文信息
     * @param select_title
     * @return
     */
    List<Blog> blogTitleSelect(String select_title);

    /**
     * 根据博文主键删除博文
     * @param id
     * @return
     */
    int deleteBlogInfo(Integer id);

    /**
     * 根据博文主键跟心博文信息
     * @param blog
     * @return
     */
    int updateBlogInfo(Blog blog);

    /**
     * 添加博文数据
     * @param blog
     * @return
     */
    int insertBlog(Blog blog);

    /**
     * 获取博文分类信息
     * @return
     */
    List<ClassBlog> getAllBlogClass();

    /**
     * 根据主键修改博文分类信息
     * @param classBlog
     * @return
     */
    int updateBlogClassInfo(ClassBlog classBlog);

    /**
     * 根据主键删除博文分类信息
     * @param id
     * @return
     */
    int deleteBlogClass(Integer id);

    /**
     * 添加博文分类信息
     * @param classBlog
     * @return
     */
    int insertBlogClass(ClassBlog classBlog);

    /**
     * 获取所有的类名和Id
     * @return
     */
    List<ClassBlog> selectAllClassNameAndId();

    /**
     * 获取总记录条数
     * @return
     */
    int getAllTotal();

    /**
     * 获取前n个记录条数
     * @param pageSize
     * @return
     */
    List<Blog> getPageSizeBlog(int pageNo,int pageSize);

    /**
     * 通过博文标题查询的总记录条数
     * @return
     */
    int getAllTotalTwo(String select_title);
}
