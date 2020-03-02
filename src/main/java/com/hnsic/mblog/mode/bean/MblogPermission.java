package com.hnsic.mblog.mode.bean;

import lombok.Data;

@Data
public class MblogPermission {
    private Long permissionId;

    private String description;

    private String name;

    private String permission;

    private String parentId;

    private Integer sortnum;
}