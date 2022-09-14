package com.todo.cn.mapper;

import com.todo.cn.controller.dto.GetTodoRes;
import com.todo.cn.controller.dto.PostTodoReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TodoMapper {

    public int insert(PostTodoReq ptr);

    public List<GetTodoRes> getList(int uno);

    public int update(PostTodoReq ptr);

    public int delete(int tno);




}
