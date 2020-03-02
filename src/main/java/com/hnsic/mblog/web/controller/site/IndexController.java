package com.hnsic.mblog.web.controller.site;

import com.hnsic.mblog.web.controller.baseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName IndexController
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/20  10:09
 * Version   1.0
 **/
@Controller
public class IndexController extends baseController {
    @GetMapping(value={"/","index"})
    public String toIndex(ModelMap model, HttpServletRequest request){

        String order = ServletRequestUtils.getStringParameter(request, "order", "newest");
        //存在就获得order属性，不存在就存入
        int pageNo = ServletRequestUtils.getIntParameter(request, "pageNo", 1);
        return "index";
    }
}
