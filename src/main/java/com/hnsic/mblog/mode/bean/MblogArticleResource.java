package com.hnsic.mblog.mode.bean;

import lombok.Data;

@Data
public class MblogArticleResource {
    private Long articleResourceId;

    private String path;

    private Long articleId;

    private Long resourceId;
}