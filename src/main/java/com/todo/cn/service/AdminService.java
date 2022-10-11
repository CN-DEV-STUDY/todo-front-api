package com.todo.cn.service;

import com.todo.cn.controller.dto.PostUserReq;
import com.todo.cn.domain.UserVO;

public interface AdminService {

    public void signup(PostUserReq postUserReq);

    UserVO findUserById(String username);
}
