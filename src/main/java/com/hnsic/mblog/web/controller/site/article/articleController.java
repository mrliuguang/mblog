package com.hnsic.mblog.web.controller.site.article;

import com.hnsic.mblog.web.controller.baseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName articleController
 * 文章操作
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/2/1  14:44
 * Version   1.0
 **/
@Controller
public class articleController extends baseController {
    @GetMapping("/toEdit")
    public String toEdit(Model model){
        return "write";
    }
}
