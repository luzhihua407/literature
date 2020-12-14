package com.aiyo407.literature.config;

import com.aiyo407.literature.interceptor.RequestInterceptor;
import com.aiyo407.literature.interceptor.ResponseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName ApplicationConfig.java
 * @Description TODO
 * @createTime 2020年06月12日 11:35:00
 */
@Configuration
public class ApplicationConfig {


    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @PostConstruct
    public void init() {
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(handlerAdapter.getReturnValueHandlers());
        handlers.add(0,new ResponseInterceptor());
        handlerAdapter.setReturnValueHandlers(handlers);
    }

}
