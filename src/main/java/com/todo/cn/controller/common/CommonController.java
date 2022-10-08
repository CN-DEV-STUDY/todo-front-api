package com.todo.cn.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CommonController {

    @RequestMapping("/")
    public String home(){

        return "home";
    }

}
