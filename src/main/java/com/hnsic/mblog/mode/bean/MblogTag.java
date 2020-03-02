package com.hnsic.mblog.mode.bean;

import lombok.Data;

import java.util.Date;

@Data
public class MblogTag {
    private Long tagId;

    private Date created;

    private Long lastArticleId;

    private String name;

    private Integer articles;

    private Date updated;
}