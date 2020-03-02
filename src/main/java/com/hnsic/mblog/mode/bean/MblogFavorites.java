package com.hnsic.mblog.mode.bean;

import lombok.Data;

import java.util.Date;

@Data
public class MblogFavorites {
    private Long favoriteId;

    private Long articleId;

    private Long userId;

    private Date created;
}