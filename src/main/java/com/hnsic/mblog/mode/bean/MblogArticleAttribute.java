package com.hnsic.mblog.mode.bean;

import lombok.Data;

@Data
public class MblogArticleAttribute {
    private Long attributeId;

    private String editor;

    private Long articleId;

    private String content;
}