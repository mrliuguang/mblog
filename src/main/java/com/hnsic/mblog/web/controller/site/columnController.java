package com.hnsic.mblog.web.controller.site;

import com.hnsic.mblog.mode.service.columnService;
import com.hnsic.mblog.web.controller.baseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName columnController
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/23  11:53
 * Version   1.0
 **/
@Controller
public class columnController extends baseController {
    @Autowired
    columnService columnService;
    @GetMapping(value = "/column/{name}")
    public String column(@PathVariable String name, Model model, HttpServletRequest request){
        model.addAttribute("page",name);
        String order = ServletRequestUtils.getStringParameter(request, "order", "newest");
        //存在就获得order属性，不存在就存入
        int pageNo = ServletRequestUtils.getIntParameter(request, "pageNo", 1);
        return "index";
    }
}
