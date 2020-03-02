package com.hnsic.mblog.web.controller.site.auth;

import com.hnsic.mblog.mode.bean.MblogUser;
import com.hnsic.mblog.mode.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * ClassName RegisterController
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/13  12:54
 * Version   1.0
 **/
@Controller
public class RegisterController {
    @Autowired
    userService userService;
    @GetMapping("/register")
    public String toRegister(Model model, HttpServletRequest request){
        model.addAttribute("pagePanel","registerPanel");
        return "login";
    }
    @PostMapping("/register")
    public String register(Model model, MblogUser user, Map<String ,Object> map){
        if(userService.findByUserName(user.getUsername())!=null)
        {
            System.out.println("用户已存在");
            map.put("msg", "用户已存在");
            return "redirect:/register";
        }
        user.setStatus(1);
        user.setCreatedate(new Date());
        user.setComments(0);
        user.setPosts(0);
        userService.addUser(user);
        return "index";
    }
}
