package com.todo.cn.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PostUserReq {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotNull
    private String[] email;

    private String[] phone;

    @NotNull
    private String gender;

    private String[] birthDate;


    @Builder
    public PostUserReq(String username ,
                       String password,
                       String name,
                       String[] email,
                       String[] phone,
                       String gender,
                       String[] birthDate) {
        this.username = username;
        this.password = password;
        this.name=name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;

    }
}
