package com.hnsic.mblog.mode.bean;

import lombok.Data;

@Data
public class MblogRole {
    private Long roleId;

    private String description;

    private String name;

    private Integer status;
}