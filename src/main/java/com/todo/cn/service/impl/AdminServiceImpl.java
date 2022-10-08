package com.todo.cn.service.impl;

import com.todo.cn.controller.dto.PostTodoReq;
import com.todo.cn.controller.dto.PostUserReq;
import com.todo.cn.mapper.AdminMapper;
import com.todo.cn.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {


    private AdminMapper mapper;


    // 회원 회원가입
    public void insertUser(PostUserReq pur) {
        mapper.signupUser(pur);
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
