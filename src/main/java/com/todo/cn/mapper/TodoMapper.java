package com.todo.cn.mapper;

import com.todo.cn.controller.dto.GetTodoRes;
import com.todo.cn.controller.dto.PostTodoReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface TodoMapper {

    public int insert(PostTodoReq ptr);

    public List<GetTodoRes> getList(int uno);

    public int update(PostTodoReq ptr);

    public int delete(int tno);

    public GetTodoRes selectTodo(int tno);

    public int insertBin(PostTodoReq ptr);

    public int todoCnt(int uno);




}
