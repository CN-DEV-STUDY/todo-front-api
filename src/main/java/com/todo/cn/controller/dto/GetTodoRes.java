package com.todo.cn.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTodoRes {
    private String title;
    private String content;
    private LocalDate regDate;
    private LocalDate endDate;
    private int tno;
    private int uno;
    private int mno;

}
