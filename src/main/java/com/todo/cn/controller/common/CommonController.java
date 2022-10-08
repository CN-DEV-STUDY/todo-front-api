package com.todo.cn.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping("/")
    public String home(){

        return "home";
    }

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/signup")
    public String signup(){

        return "signup";
    }

}
