package com.hnsic.mblog.mode.service.impl;

import com.hnsic.mblog.mode.bean.MblogColumn;
import com.hnsic.mblog.mode.mapper.MblogColumnMapper;
import com.hnsic.mblog.mode.service.columnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName columnServiceImpl
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/19  15:33
 * Version   1.0
 **/
@Service
public class columnServiceImpl implements columnService {
    @Autowired
    MblogColumnMapper columnMapper;
    @Override
    public List<MblogColumn> findAll() {
        return columnMapper.selectAll();
    }
}
