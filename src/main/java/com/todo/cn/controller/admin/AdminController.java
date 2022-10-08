package com.todo.cn.controller.admin;

import com.todo.cn.controller.dto.PostUserReq;
import com.todo.cn.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/signup")
    public String signup(){

        return "signup";
    }

    @PostMapping("/signup")
    public String signupUser(PostUserReq pur){
        service.signup(pur);
        return "redirect:/admin/login";
    }


}
