package com.hnsic.mblog.mode.bean;

import lombok.Data;

import java.util.Date;

@Data
public class MblogMessage {
    private Long messageId;

    private Date created;

    private Long fromId;

    private Long articleId;

    private Long userId;

    private Integer status;
}