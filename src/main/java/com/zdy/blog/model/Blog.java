package com.zdy.blog.model;

import java.util.Date;

public class Blog {
    private Integer id;

    private String title;

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdtime;

    private Integer classid;

    private String context;

    private ClassBlog classBlog;

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public ClassBlog getClassBlog() {
        return classBlog;
    }

    public void setClassBlog(ClassBlog classBlog) {
        this.classBlog = classBlog;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdtime=" + createdtime +
                ", classid=" + classid +
                ", context='" + context + '\'' +
                ", classBlog=" + classBlog +
                ", author='" + author + '\'' +
                '}';
    }
}