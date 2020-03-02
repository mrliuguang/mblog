package com.hnsic.mblog.web.controller.site.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName userController
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/17  18:37
 * Version   1.0
 **/
@Controller
@RequestMapping("/users")
public class userController {
    @GetMapping(value = "/{userId}")
    public String userMain(){

        return "user_main";
    }
}
