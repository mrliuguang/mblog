package com.hnsic.mblog.mode.bean;

import lombok.Data;

@Data
public class MblogArticleTag {
    private Long tagArticleId;

    private Long articleId;

    private Long tagId;

    private Integer weight;
}