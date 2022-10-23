package com.todo.cn.controller.admin;

import com.todo.cn.controller.dto.PostUserReq;
import com.todo.cn.domain.UsersVO;
import com.todo.cn.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("postUserReq", new PostUserReq());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupUser(@Validated @ModelAttribute PostUserReq pur , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.info("errors ={}", bindingResult.getAllErrors()); // bindingResult는 자동으로 view에 넘어가기 때문에 model에 넣는 로직은 생략해도 됨
            return "signup";
        }

        pur.setPassword(passwordEncoder.encode(pur.getPassword()));
        service.signup(pur);
        return "redirect:/admin/login";
    }

    @GetMapping("/checkId")
    @ResponseBody
    public ResponseEntity<Integer> checkId(String username){
        int result = service.checkId(username);

        return new ResponseEntity<>(result , HttpStatus.OK);

    }


}
