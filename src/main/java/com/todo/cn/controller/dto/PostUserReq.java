package com.todo.cn.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PostUserReq {

    private String username;
    private String password;

    private String name;

    private String email;

    private String phone;

    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;


    @Builder
    public PostUserReq(String username ,
                       String password,
                       String name,
                       String email,
                       String phone,
                       String gender,
                       LocalDate birthDate) {
        this.username = username;
        this.password = password;
        this.name=name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;

    }
}
