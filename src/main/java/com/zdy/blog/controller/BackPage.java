package com.zdy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backPage")
public class BackPage {

    @RequestMapping("/top")
    public String top(){
        return "backPage/top";
    }

    @RequestMapping("/left")
    public String left(){
        return "backPage/left";
    }

    @RequestMapping("/right")
    public String right(){
        return "backPage/right";
    }

}
