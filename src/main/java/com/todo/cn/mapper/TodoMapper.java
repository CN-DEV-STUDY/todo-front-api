package com.todo.cn.mapper;

import com.todo.cn.controller.dto.GetTodoRes;
import com.todo.cn.controller.dto.PostTodoReq;
import com.todo.cn.domain.TodoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface TodoMapper {

    public int insert(PostTodoReq ptr);

    public List<GetTodoRes> getList(int uno);

    public List<GetTodoRes> getBinList(int uno);

    public int update(PostTodoReq ptr);

    public int delete(int tno);

    public TodoVO selectTodo(int tno);

    public int insertBin(PostTodoReq ptr);

    public int todoCnt(int uno);

    public int restore(int tno);

    public int removeBin(int tno);



}
