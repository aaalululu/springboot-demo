package com.chianlulu.springbootdemo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class MembersRequest {

    @NotNull
    private String memberName;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Length(min = 4, max = 12, message = "password長度需為4~12")
    private String memberPassword;
    private String phone;
    private String address;


}
