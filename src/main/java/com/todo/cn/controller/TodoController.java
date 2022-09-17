package com.todo.cn.controller;

import com.todo.cn.controller.dto.GetTodoRes;
import com.todo.cn.controller.dto.PostTodoReq;
import com.todo.cn.domain.TodoVO;
import com.todo.cn.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping(value = "/register" , consumes = "application/json" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Integer> create(@RequestBody PostTodoReq ptr){
        int result = service.register(ptr);
        return result == 1 ? new ResponseEntity<Integer>(result,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/list/{uno}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<GetTodoRes>> getList(@PathVariable("uno") int uno){
        return new ResponseEntity<>(service.getList(uno), HttpStatus.OK);
    }

    @PutMapping(value = "/modify/{tno}" , consumes = "application/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PostTodoReq> modify(@PathVariable("tno") int tno ,@RequestBody PostTodoReq ptr){
        ptr.setTno(tno);
        int result = service.modify(ptr);
        return result == 1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(value = "/delete/{tno}")
    public ResponseEntity<TodoVO> delete(@PathVariable("tno") int tno){
        TodoVO todoVO = service.selectTodo(tno);

        service.removeAndInsertBin(todoVO);

        return new ResponseEntity<TodoVO>(HttpStatus.OK);
    }

    @GetMapping("/selectCount/{uno}")
    public int todoCnt(@PathVariable("uno") int uno){
        int result = service.todoCnt(uno);
        return result;
    }

}
