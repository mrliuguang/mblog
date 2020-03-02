package com.hnsic.mblog.component;

import com.hnsic.mblog.mode.service.columnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;
/**
 * ClassName tagComponent
 * Description too
 * Aouthor   Admin_LG
 * Date      2020/1/20  11:33
 * Version   1.0
 **/
@Component
public class tagComponent extends AbstractProcessorDialect {
    private static final String tag_name="column";
    private static final String PREFIX="col";
    public tagComponent() {
        super(tag_name, PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new lableComponent(PREFIX));
        return processors;
    }
}
