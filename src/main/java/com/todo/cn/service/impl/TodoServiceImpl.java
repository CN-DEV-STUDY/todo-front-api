package com.todo.cn.service.impl;

import com.todo.cn.controller.dto.GetTodoRes;
import com.todo.cn.controller.dto.PostTodoReq;
import com.todo.cn.domain.TodoVO;
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


    public void remove(int tno) {
        mapper.delete(tno);
    }


    public void insertBin(PostTodoReq ptr) {
        mapper.insertBin(ptr);

    }

    @Override
    public TodoVO selectTodo(int tno) {
        return mapper.selectTodo(tno);
    }

    @Override
    public int todoCnt(int uno) {
        return mapper.todoCnt(uno);
    }

    @Transactional
    @Override
    public void removeAndInsertBin(TodoVO todoVO) {
        // Todo테이블 del_yn 처리
        remove(todoVO.getTno()); // del_yn = 'Y'로 바꿈


        // bin테이블에 insert 처리
        PostTodoReq ptr = PostTodoReq.builder()
                .uno(todoVO.getUno())
                .tno(todoVO.getTno())
                .mno(todoVO.getMno())
                .title(todoVO.getTitle())
                .content(todoVO.getContent())
                .build();

        insertBin(ptr);


    }

    public void restore(int tno) {
        mapper.restore(tno);
    }


    public void removeBin(int tno) {
        mapper.removeBin(tno);
    }

    @Transactional
    @Override
    public void restoreTodo(int tno) {

        // 휴지통에 있는 todo 먼저 삭제
        removeBin(tno);

        // del_yn = 'N' 으로 바꿈
        restore(tno);
    }
}
