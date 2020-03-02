package com.hnsic.mblog.web.controller.site.auth;

import com.hnsic.mblog.mode.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName logoutController
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/19  13:50
 * Version   1.0
 **/
@Controller
public class logoutController {
    @Autowired
    userService userService;
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        Subject currentUser = SecurityUtils.getSubject();
        //all done - log out!   登出
        currentUser.logout();
        return "index";
    }

}
