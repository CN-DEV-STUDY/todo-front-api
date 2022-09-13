package com.todo.cn.service.impl;

import com.todo.cn.controller.dto.PostTodoReq;
import com.todo.cn.mapper.TodoMapper;
import com.todo.cn.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoMapper mapper;

    @Override
    public int register(PostTodoReq ptr) {
        return mapper.insert(ptr);
    }
}
