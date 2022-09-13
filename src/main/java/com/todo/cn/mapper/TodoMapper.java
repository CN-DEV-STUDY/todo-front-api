package com.todo.cn.mapper;

import com.todo.cn.controller.dto.PostTodoReq;
import org.apache.ibatis.annotations.Mapper;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
>>>>>>> d1c17413a6a1b3f7ddf92c9d9919f52262e54b8d

@Mapper
public interface TodoMapper {

    public int insert(PostTodoReq ptr);


}
