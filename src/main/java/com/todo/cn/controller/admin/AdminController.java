package com.todo.cn.controller.admin;

import com.todo.cn.controller.dto.PostUserReq;
import com.todo.cn.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Log4j2
public class AdminController {

    private final AdminService service;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("pur", new PostUserReq());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupUser(@Validated @ModelAttribute("pur") PostUserReq pur , BindingResult bindingResult){
        pur.setPassword(passwordEncoder.encode(pur.getPassword()));

        if(bindingResult.hasErrors()){
            log.info("errors ={}", bindingResult); // bindingResult는 자동으로 view에 넘어가기 때문에 model에 넣는 로직은 생략해도 됨
            return "redirect:/admin/signup";
        }

        service.signup(pur);
        return "redirect:/admin/login";
    }


}
