package com.todo.cn.controller;

import com.todo.cn.controller.dto.PostTodoReq;
import com.todo.cn.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping(value = "/register" , consumes = "application/json" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PostTodoReq> create(@RequestBody PostTodoReq ptr){
        int result = service.register(ptr);
        return result == 1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
