package com.todo.cn.service;

import com.todo.cn.controller.dto.PostUserReq;
import com.todo.cn.domain.UsersVO;

public interface AdminService {

    public void signup(PostUserReq postUserReq);

    UsersVO findUserById(String username);
}
