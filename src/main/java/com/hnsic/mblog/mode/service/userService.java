package com.hnsic.mblog.mode.service;

import com.hnsic.mblog.mode.bean.MblogUser;

/**
 * ClassName UserService
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/17  15:07
 * Version   1.0
 **/
public interface userService {
    public MblogUser findByUserName(String userName);
    public int addUser(MblogUser user);
}
