package com.hnsic.mblog.mode.service.impl;

import com.hnsic.mblog.mode.bean.MblogUser;
import com.hnsic.mblog.mode.mapper.MblogUserMapper;
import com.hnsic.mblog.mode.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName UserServiceImpl
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/17  15:12
 * Version   1.0
 **/
@Service
public class userServiceImpl implements userService {
    @Autowired
    MblogUserMapper mblogUserMapper;
    @Override
    public MblogUser findByUserName(String userName) {
        return mblogUserMapper.findByUsername(userName);
    }

    @Override
    public int addUser(MblogUser user) {
        return mblogUserMapper.insert(user);
    }
}
