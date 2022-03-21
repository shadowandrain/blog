package com.zdy.blog.controller;

import com.zdy.blog.model.Blog;
import com.zdy.blog.model.ClassBlog;
import com.zdy.blog.model.Comment;
import com.zdy.blog.model.Users;
import com.zdy.blog.service.AdminService;
import com.zdy.blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class Admin {

    @Autowired
    private AdminService adminService;

    int result = 0;

    //总记录条数
    int totalSize = 0;

    //每页记录条数
    int pageSize = 5;

    //总页数
    int pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;

    //当前页数
    int nowPage = 1;


    @RequestMapping("/main")
    public String mainPage(){
        return "backPage/main";
    }

    @RequestMapping("/right")
    public String rightPage(){
        return "backPage/right";
    }

    /**
     * 跳转发布博文页面
     * @return
     */
    @RequestMapping("/putBlog")
    public String putBlog(Model model){
        //获取所有的类名和对应的Id
        List<ClassBlog> allClassNameList = adminService.selectAllClassNameAndId();
        model.addAttribute("allClassNameList",allClassNameList);
        return "admin/putBlog";
    }

    /**
     * 跳转博文管理页面
     * @return
     */
    @RequestMapping("/blogSet")
    public String blogSet(Integer nowPage,Model model){

        //总记录条数
        totalSize = adminService.getAllTotal();

        //总页数
        pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;

        //获取所有博文信息
        //List<Blog> blogsList = adminService.getAllBlog();

        //获取从nowPage页开始，每页pageSize个博文信息
        List<Blog> blogsList = adminService.getPageSizeBlog((nowPage-1) * pageSize,pageSize);

        model.addAttribute("blogsList",blogsList);
        model.addAttribute("totalSize",totalSize);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("pageCount",pageCount);

        return "admin/blogSet";
    }

    /**
     * 跳转添加博文分类页面
     * @return
     */
    @RequestMapping("/insertBlogClass")
    public String insertBlogClass(){
        return "admin/insertBlogClass";
    }

    /**
     * 跳转博文分类管理页面
     * @return
     */
    @RequestMapping("/blogClassSet")
    public String blogClassSet(Model model){
        List<ClassBlog> classBlogList = adminService.getAllBlogClass();
        model.addAttribute("classBlogList",classBlogList);
        return "admin/blogClassSet";
    }

    /**
     * 跳转用户管理页面
     * @return
     */
    @RequestMapping("/userSet")
    public String userSet(Model model){
        List<Users> usersList = adminService.getAllUser();
        model.addAttribute("userList",usersList);
        return "admin/userSet";
    }

    /**
     * 跳转用户编辑页面
     * @return
     */
    @RequestMapping("/userReset")
    public String userReset(String username,String password,String email,String power, Model model){
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPower(power);
        model.addAttribute("user",user);
        return "admin/userReset";
    }

    /**
     * 管理员修改用户信息
     * @param username
     * @param password
     * @param email
     * @param power
     * @return
     */
    @RequestMapping("/resetInfo")
    public String resetInfo(String username ,String password,String email,String power,Model model){
        String newPassword = MD5Util.getMD5(password);
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(newPassword);
        users.setEmail(email);
        users.setPower(power);
        result = adminService.updataInfo(users);
        if(result != 0){
            List<Users> usersList = adminService.getAllUser();
            model.addAttribute("userList",usersList);
            return "admin/userSet";
        }else{
            return "admin/resetInfoError";
        }
    }

    /**
     * 管理员删除用户信息
     * @param username
     * @param power
     * @param model
     * @return
     */
    @RequestMapping("/deleteUserInfo")
    public String deleteUserInfo(String username,String power,Model model){
        result = adminService.delectUserInfo(username,power);
        if(result != 0){
            List<Users> usersList = adminService.getAllUser();
            model.addAttribute("userList",usersList);
            return "admin/userSet";
        }else{
            return "admin/deleteError";
        }
    }

    /**
     * 根据博文标题获取博文信息
     * @param select_title
     * @param model
     * @return
     */
    @RequestMapping("/blogTitleSelect")
    public String blogTitleSelect(String select_title,Model model){
        List<Blog> blogsList = adminService.blogTitleSelect(select_title);
        //总记录条数
        totalSize = adminService.getAllTotalTwo(select_title);
        //总页数
        pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
        model.addAttribute("totalSize",totalSize);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("blogsList",blogsList);
        return "admin/blogSet";
    }

    /**
     * 进入博文编辑页面
     * @param title
     * @param classid
     * @param context
     * @param model
     * @return
     */
    @RequestMapping("/blogInfoEditPage")
    public String blogInfoEditPage(String classname,Integer id,String title,Integer classid,String context,Model model){
        String newClassid = String.valueOf(classid);
        model.addAttribute("id",id);
        model.addAttribute("title",title);
        model.addAttribute("context",context);
        model.addAttribute("classid",newClassid);
        model.addAttribute("classname1",classname);

        //获取所有的类名和对应的Id
        List<ClassBlog> allClassNameList = adminService.selectAllClassNameAndId();
        model.addAttribute("allClassNameList",allClassNameList);
//        Blog blog = new Blog();
//        blog.setTitle(title);
//        blog.setContext(context);
//        blog.setClassid(classid);
//        model.addAttribute("blog",blog);
        return "admin/blogInfoEditPage";
    }

    /**
     * 根据博文id更新博文数据
     * @param id
     * @param title
     * @param classid
     * @param context
     * @param model
     * @return
     */
    @RequestMapping("/resetBlogInfo")
    public String resetBlogInfo(Integer id,String title,Integer classid,String context,Model model){
        Blog blog = new Blog();
        blog.setId(id);
        blog.setTitle(title);
        blog.setClassid(classid);
        blog.setContext(context);
        result = adminService.updateBlogInfo(blog);
        if(result != 0){
            totalSize = adminService.getAllTotal();
            pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
            List<Blog> blogsList = adminService.getPageSizeBlog((nowPage-1) * pageSize,pageSize);
            model.addAttribute("blogsList",blogsList);
            model.addAttribute("totalSize",totalSize);
            model.addAttribute("pageSize",pageSize);
            model.addAttribute("nowPage",nowPage);
            model.addAttribute("pageCount",pageCount);
            return "admin/blogSet";
        }else{
            return "admin/blogSetError";
        }
    }

    /**
     * 根据博文主键删除博文
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/deleteBlogInfo")
    public String deleteBlogInfo(Integer id,Integer nowPage,Model model){
        //String newDate = DateUtil.newDate(createdtime);
        result = adminService.deleteBlogInfo(id);
        if(result != 0){
            totalSize = adminService.getAllTotal();
            pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
            List<Blog> blogsList = adminService.getPageSizeBlog((nowPage-1) * pageSize,pageSize);
            model.addAttribute("blogsList",blogsList);
            model.addAttribute("totalSize",totalSize);
            model.addAttribute("pageSize",pageSize);
            model.addAttribute("nowPage",nowPage);
            model.addAttribute("pageCount",pageCount);
            return "admin/blogSet";
        }else{
            return "admin/deleteBlogError";
        }
    }

    /**
     * 添加博文信息
     * @return
     */
    @RequestMapping("/insertBlog")
    public String insertBlog(String title,Integer classid,String context,Model model){
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setClassid(classid);
        blog.setContext(context);
        blog.setCreatedtime(new Date());
        result = adminService.insertBlog(blog);
        if(result != 0){
            totalSize = adminService.getAllTotal();
            pageCount = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
            List<Blog> blogsList = adminService.getPageSizeBlog((nowPage-1) * pageSize,pageSize);
            model.addAttribute("blogsList",blogsList);
            model.addAttribute("totalSize",totalSize);
            model.addAttribute("pageSize",pageSize);
            model.addAttribute("nowPage",nowPage);
            model.addAttribute("pageCount",pageCount);
            return "admin/blogSet";
        }else{
            return "admin/insertBlogError";
        }
    }

    /**
     * 进入博文分类编辑页面
     * @param name
     * @param id
     * @param sort
     * @param model
     * @return
     */
    @RequestMapping("/blogClassSetPage")
    public String blogClassSetPage(String name,Integer id ,Integer sort,Model model){
        model.addAttribute("name",name);
        model.addAttribute("id",id);
        model.addAttribute("sort",sort);
        return "admin/blogClassSetPage";
    }

    /**
     * 修改博文分类信息
     * @param name
     * @param id
     * @param sort
     * @param model
     * @return
     */
    @RequestMapping("/setBlogClass")
    public String setBlogClass(String name,Integer id,Integer sort,Model model){
        ClassBlog classBlog = new ClassBlog();
        classBlog.setName(name);
        classBlog.setId(id);
        classBlog.setSort(sort);
        result = adminService.updateBlogClassInfo(classBlog);
        if(result != 0){
            List<ClassBlog> classBlogList = adminService.getAllBlogClass();
            model.addAttribute("classBlogList",classBlogList);
            return "admin/blogClassSet";
        }
        return "admin/blogClassSetError";
    }

    /**
     * 根据主键删除博文分类信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/blogClassDelete")
    public String blogClassDelete(Integer id,Model model){
        result = adminService.deleteBlogClass(id);
        if(result != 0){
            List<ClassBlog> classBlogList = adminService.getAllBlogClass();
            model.addAttribute("classBlogList",classBlogList);
            return "admin/blogClassSet";
        }else{
            return "admin/blogClassDeleteError";
        }
    }

    /**
     * 添加博文分类信息
     * @param name
     * @param sort
     * @param model
     * @return
     */
    @RequestMapping("/addBlogClass")
    public String addBlogClass(String name,Integer sort,Model model){
        ClassBlog classBlog = new ClassBlog();
        classBlog.setSort(sort);
        classBlog.setName(name);
        result = adminService.insertBlogClass(classBlog);
        if(result != 0){
            List<ClassBlog> classBlogList = adminService.getAllBlogClass();
            model.addAttribute("classBlogList",classBlogList);
            return "admin/blogClassSet";
        }else{
            return "admin/addBlogClassError";
        }
    }
}
