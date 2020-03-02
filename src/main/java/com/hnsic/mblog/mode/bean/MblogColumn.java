package com.hnsic.mblog.mode.bean;

import lombok.Data;

@Data
public class MblogColumn {
    private Integer columnId;

    private String columnName;

    private String columnValue;

    private Integer columnStatus;

    private Integer weight;
}