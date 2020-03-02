package com.hnsic.mblog.component;

import com.hnsic.mblog.mode.bean.MblogColumn;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.context.WebEngineContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IOpenElementTag;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

public class lableComponent extends AbstractAttributeTagProcessor {
    private static final String TEXT_ATTRIBUTE = "id";


    public lableComponent(String prefix) {
        super(TemplateMode.HTML, prefix, "a", false, TEXT_ATTRIBUTE, true, 1000, true);
    }

    @Override
    protected void doProcess(ITemplateContext iTemplateContext,
                             IProcessableElementTag iProcessableElementTag,
                             AttributeName attributeName, String s,
                             IElementTagStructureHandler iElementTagStructureHandler) {
        //根据自定义标签创建对应菜单
        WebEngineContext webEngineContext=(WebEngineContext)iTemplateContext;
        ServletContext servletContext=webEngineContext.getServletContext();
        //获取上下文，后台操作只需改变上下文就能影响标签
        List<MblogColumn> columnNames = new ArrayList<>();
        columnNames=(List<MblogColumn>)servletContext.getAttribute("columns");
        final IModelFactory modelFactory = iTemplateContext.getModelFactory();
        final IModel model = modelFactory.createModel();//创建标签和文本的model
        IOpenElementTag tag2=null;
        IOpenElementTag tag=null;
        for(MblogColumn column:columnNames) {
            tag2 =modelFactory.createOpenElementTag("li","class","nav-item ",false);
            tag = modelFactory.createOpenElementTag("a");
            tag=modelFactory.setAttribute(tag, "class", "nav-link");
            tag=modelFactory.setAttribute(tag, "href", "http://localhost:8081/column/"+column.getColumnValue());
            model.add(tag2);
            model.add(tag);
            model.add(modelFactory.createText(column.getColumnName()));
            model.add(modelFactory.createCloseElementTag("a"));
            model.add(modelFactory.createCloseElementTag("li"));
        }
        iElementTagStructureHandler.replaceWith(model,false);
    }

}