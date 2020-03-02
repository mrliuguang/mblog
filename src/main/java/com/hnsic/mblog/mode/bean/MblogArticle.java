package com.hnsic.mblog.mode.bean;

import lombok.Data;

import java.util.Date;

@Data
public class MblogArticle {
    private Long articleId;

    private Long authorId;

    private Integer columnId;

    private Integer comments;

    private Date created;

    private Integer favors;

    private Integer status;

    private String summary;

    private String tags;

    private String thumbnail;

    private String title;

    private Integer views;

    private Integer weight;
}