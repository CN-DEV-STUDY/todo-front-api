package com.todo.cn.mapper;

import com.todo.cn.controller.dto.PostTodoReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

    public int insert(PostTodoReq ptr);


}
