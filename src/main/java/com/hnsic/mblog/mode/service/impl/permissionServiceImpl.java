package com.hnsic.mblog.mode.service.impl;

import com.hnsic.mblog.mode.bean.MblogPermission;
import com.hnsic.mblog.mode.mapper.MblogPermissionMapper;
import com.hnsic.mblog.mode.service.permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName PermissionServiceImpl
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/17  14:02
 * Version   1.0
 **/
@Service
public class permissionServiceImpl implements permissionService {
    @Autowired
    MblogPermissionMapper mblogPermissionMapper;
    @Override
    public List<MblogPermission> findAll() {
        return  mblogPermissionMapper.selectAll();
    }
}
