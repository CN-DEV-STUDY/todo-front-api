package com.todo.cn.service;

import com.todo.cn.controller.dto.GetTodoRes;
import com.todo.cn.controller.dto.PostTodoReq;

import java.util.List;

public interface TodoService {
    public int register(PostTodoReq ptr);

    public List<GetTodoRes> getList(int uno);

    public int modify(PostTodoReq ptr);

    public int remove(int tno);

}
