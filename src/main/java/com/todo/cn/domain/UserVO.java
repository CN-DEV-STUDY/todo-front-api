package com.todo.cn.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVO {
    private int uno;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private LocalDateTime birthDate;
}
