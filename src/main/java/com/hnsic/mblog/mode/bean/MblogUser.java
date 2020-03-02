package com.hnsic.mblog.mode.bean;

import lombok.Data;

import java.util.Date;

@Data
public class MblogUser {
    private Long userId;

    private String username;

    private String email;

    private String password;

    private Integer status;

    private Date birthday;

    private Integer gender;

    private Date createdate;

    private Date lastLogin;

    private Integer comments;

    private Integer posts;

    private String icon;

    private String signature;
}