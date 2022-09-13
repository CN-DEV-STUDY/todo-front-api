package com.todo.cn.mapper;

import com.todo.cn.controller.dto.PostTodoReq;
import org.springframework.stereotype.Repository;


public interface TodoMapper {

    public int insert(PostTodoReq ptr);


}
