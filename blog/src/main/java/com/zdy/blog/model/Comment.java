package com.zdy.blog.model;

import java.util.Date;

public class Comment {
    private Integer id;

    private Date createdtime;

    private String username;

    private Integer blogid;

    private String context;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", createdtime=" + createdtime +
                ", username='" + username + '\'' +
                ", blogid=" + blogid +
                ", context='" + context + '\'' +
                '}';
    }
}