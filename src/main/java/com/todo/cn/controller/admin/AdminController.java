package com.todo.cn.controller.admin;

import com.todo.cn.controller.dto.PostUserReq;
import com.todo.cn.domain.UserVO;
import com.todo.cn.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
@SessionAttributes({"loginUser", "next"})
@RequiredArgsConstructor
@Log4j2
public class AdminController {

    private AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login(@RequestHeader(name="Referer", required = false) String referer,
                        @SessionAttribute(required = false) String next,
                        Model model){
        log.info("referer = {}", referer);

        if(next == null) {
            model.addAttribute("next", referer);
        }

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
