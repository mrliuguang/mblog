package com.hnsic.mblog.component;

import com.hnsic.mblog.mode.bean.MblogColumn;
import com.hnsic.mblog.mode.service.columnService;
import com.hnsic.mblog.mode.service.optionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName startupConfig
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/19  15:25
 * Version   1.0
 **/
@Slf4j
@Component
public class startupCompent implements ApplicationRunner, ServletContextAware {
    @Autowired
    columnService columnService;
    @Autowired
    optionService optionService;
    ServletContext servletContext;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("加载初始组件....");
        loadOption();
        loadColumn();
        log.info("加载完成！");
    }
    public void loadOption(){
        this.servletContext.setAttribute("options", optionService.findAll());
    }
    public void loadColumn(){
        List<MblogColumn> columns=columnService.findAll();
        columns.sort(new Comparator<MblogColumn>() {
            @Override
            public int compare(MblogColumn o1, MblogColumn o2) {
                return o1.getWeight()>o2.getWeight()?1:0;
            }
        });
        List<String> columnNames = new ArrayList<>();
        for(MblogColumn column:columns) {
            columnNames.add(column.getColumnName());
        }
        this.servletContext.setAttribute("columns" , columns);
    }
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }
}
