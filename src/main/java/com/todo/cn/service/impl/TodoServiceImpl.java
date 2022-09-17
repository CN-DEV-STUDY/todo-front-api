package com.todo.cn.service.impl;

import com.todo.cn.controller.dto.GetTodoRes;
import com.todo.cn.controller.dto.PostTodoReq;
import com.todo.cn.mapper.TodoMapper;
import com.todo.cn.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoMapper mapper;

    @Override
    public int register(PostTodoReq ptr) {
        return mapper.insert(ptr);
    }

    @Override
    public List<GetTodoRes> getList(int uno) {
        return mapper.getList(uno);
    }

    @Override
    public int modify(PostTodoReq ptr) {
        return mapper.update(ptr);
    }


//    @Override
//    public int remove(int tno) {
//        return mapper.delete(tno);
//    }

    @Transactional
    @Override
    public void insertBin(PostTodoReq ptr) {
        mapper.delete(ptr.getTno());
        mapper.insertBin(ptr);

    }

    @Override
    public GetTodoRes selectTodo(int tno) {
        return mapper.selectTodo(tno);
    }

    @Override
    public int todoCnt(int uno) {
        return mapper.todoCnt(uno);
    }
}
