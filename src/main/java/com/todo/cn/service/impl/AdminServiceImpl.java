package com.todo.cn.service.impl;

import com.todo.cn.controller.dto.PostTodoReq;
import com.todo.cn.controller.dto.PostUserReq;
import com.todo.cn.domain.UserVO;
import com.todo.cn.mapper.AdminMapper;
import com.todo.cn.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {


    private final AdminMapper mapper;


    private final PasswordEncoder passwordEncoder;


    // 회원 회원가입
    public void insertUser(PostUserReq pur) {

        String password = passwordEncoder.encode(pur.getPassword());

        String e1 = pur.getEmail()[0];
        String e2 = pur.getEmail()[1];
        String email = e1 + "@" + e2;

        String p1 = pur.getPhone()[0];
        String p2 = pur.getPhone()[1];
        String p3 = pur.getPhone()[2];
        String phone = p1+p2+p3;

        String b1 = pur.getBirthDate()[0];
        String b2 = pur.getBirthDate()[1];
        String b3 = pur.getBirthDate()[2];
        String birth = b1+"-"+b2+"-"+b3;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(birth, formatter);

        UserVO userVO = UserVO.builder()
                .username(pur.getUsername())
                .password(password)
                .name(pur.getName())
                .email(email)
                .phone(phone)
                .gender(pur.getGender())
                .birthDate(birthDate)
                .build();

        mapper.signupUser(userVO);
    }
    public void insertAuthorities(PostUserReq pur) {
        mapper.insertAuthorities(pur);

    }

    @Override
    @Transactional
    public void signup(PostUserReq pur) {
        insertUser(pur);
        insertAuthorities(pur);
    }
}
