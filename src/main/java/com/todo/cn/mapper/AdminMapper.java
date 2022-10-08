package com.todo.cn.mapper;

import com.todo.cn.controller.dto.PostUserReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    public int signupUser(PostUserReq pur);
    public int insertAuthorities(PostUserReq pur);
}
