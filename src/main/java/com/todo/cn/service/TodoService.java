package com.todo.cn.service;

import com.todo.cn.controller.dto.GetTodoRes;
import com.todo.cn.controller.dto.PostTodoReq;
import com.todo.cn.domain.TodoVO;

import java.util.List;

public interface TodoService {
    public int register(PostTodoReq ptr);

    public List<GetTodoRes> getList(int uno);

    public List<GetTodoRes> getBinList(int uno);

    public int modify(PostTodoReq ptr);

//    public int remove(int tno);

//    public void insertBin(PostTodoReq ptr);

    public TodoVO selectTodo(int tno);

    public int todoCnt(int uno);


    public void removeAndInsertBin(TodoVO todoVO);

    public void restoreTodo(int tno);

    public int removeTodoPer(int tno);

}
