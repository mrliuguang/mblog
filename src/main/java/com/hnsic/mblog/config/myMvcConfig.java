package com.hnsic.mblog.config;

import com.hnsic.mblog.componet.SimpleleHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc
@Configuration
public class myMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer()
    {
        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/unauth").setViewName("unauth");
                registry.addViewController("/test").setViewName("test");
            }
            @Override
            /**
             * 增加自己的简单拦截，拦截所有请求(并未作任何处理)，开放静态资源
             */
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new SimpleleHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/users/login","/**/*.css",
                        "/**/*.js", "/**/*.png", "/**/*.jpg",
                        "/**/*.jpeg", "/**/*.gif", "/**/fonts/*","/**/*.svg","/**/*.ico","/static/*.png");
            }
        };
        return webMvcConfigurer;
    }
}
