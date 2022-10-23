package com.todo.cn.mapper;

import com.todo.cn.controller.dto.PostUserReq;
import com.todo.cn.domain.UsersVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    public int signupUser(UsersVO userVO);
    public int insertAuthorities(PostUserReq pur);

    UsersVO findUserById(String username);

    public int checkId(String username);
}
