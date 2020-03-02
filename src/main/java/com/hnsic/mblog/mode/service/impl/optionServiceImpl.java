package com.hnsic.mblog.mode.service.impl;

import com.hnsic.mblog.mode.bean.MblogOptions;
import com.hnsic.mblog.mode.mapper.MblogOptionsMapper;
import com.hnsic.mblog.mode.service.optionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName optionServiceImpl
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/19  15:33
 * Version   1.0
 **/
@Service
public class optionServiceImpl implements optionService {
    @Autowired
    MblogOptionsMapper optionsMapper;
    @Override
    public List<MblogOptions> findAll() {
        return optionsMapper.selectAll();
    }
}
