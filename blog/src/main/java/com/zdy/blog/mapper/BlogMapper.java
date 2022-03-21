package com.zdy.blog.mapper;

import com.zdy.blog.model.Blog;

import java.util.Date;
import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    //int deleteByInfo(Integer blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);

    List<Blog> selectAll();

    /**
     * 表连接查询
     * @return
     */
    List<Blog> selectAllTwo();

    List<Blog> selectByTitle(String title);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

    /**
     * 获取总记录条数
     * @return
     */
    int selectAllTotle();

    /**
     * 获取前n个记录条数
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Blog> selectPageSizeBlog(int pageNo,int pageSize);

    /**
     * 根据博文标题查询的总记录条数
     * @return
     */
    int selectAllTotleTwo(String title);
}