package com.hnsic.mblog.shiro;


import com.hnsic.mblog.mode.bean.MblogPermission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName FilterChainDefinitionMapBuilder
 * Description too
 * Aouthor   Admin_LG
 * Date      2019/12/10  19:57
 * Version   1.0
 **/
public class FilterChainDefinitionMapBuilder {
    @Autowired
    com.hnsic.mblog.mode.service.permissionService permissionService;
    public Map<String,String> builder() {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap();
        List<MblogPermission> permissionList= permissionService.findAll();
        for (MblogPermission permission:permissionList) {
            filterChainDefinitionMap.put(permission.getName(),permission.getPermission());
            System.out.println(filterChainDefinitionMap.get(permission.getPermission()));
        }
        return filterChainDefinitionMap;
    }
}
