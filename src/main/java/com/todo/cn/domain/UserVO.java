package com.todo.cn.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
public class UserVO {
    private int uno;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private LocalDate birthDate;

    @Builder
    public UserVO(int uno,
                  String username,
                  String password,
                  String name,
                  String email,
                  String phone,
                  String gender,
                  LocalDate birthDate) {
        this.uno = uno;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
    }
}
