package com.todo.cn.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoVO {

    private int tno;

    private String title;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime updateDate;

    private LocalDateTime endDate;

    private String del_yn;


}
