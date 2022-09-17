package com.todo.cn.controller.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PostTodoReq {

    private int tno;

    private String title;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private int mno;

    private int uno;
    @Builder
    public PostTodoReq(int tno, String title, String content, LocalDate endDate, int mno, int uno) {
        this.tno = tno;
        this.title = title;
        this.content = content;
        this.endDate = endDate;
        this.mno = mno;
        this.uno = uno;
    }
}
