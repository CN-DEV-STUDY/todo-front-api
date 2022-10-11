package com.todo.cn.mapper;

import com.todo.cn.controller.dto.PostUserReq;
import com.todo.cn.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    public int signupUser(UserVO userVO);
    public int insertAuthorities(PostUserReq pur);

    UserVO findUserById(String username);
}
