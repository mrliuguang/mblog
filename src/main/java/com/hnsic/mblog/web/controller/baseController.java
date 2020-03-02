package com.hnsic.mblog.web.controller;

import com.hnsic.mblog.web.formatter.StringEscapeEditor;
import groovy.util.logging.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName baseController
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/23  12:26
 * Version   1.0
 **/
@Slf4j
public class baseController {
        @InitBinder
        public void initBinder(ServletRequestDataBinder binder) {
            /**
             * 自动转换日期类型的字段格式
             */
            binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));

            /**
             * 防止XSS攻击
             */
            binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false));

        }

}
