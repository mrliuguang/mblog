package com.hnsic.mblog.mode.bean;

import lombok.Data;

import java.util.Date;

@Data
public class MblogResource {
    private Long mblogResourceId;

    private Date create;

    private String md5;

    private String path;
}