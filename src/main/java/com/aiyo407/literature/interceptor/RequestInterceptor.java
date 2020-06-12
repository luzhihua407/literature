package com.aiyo407.literature.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName RequestInterceptor.java
 * @Description TODO
 * @createTime 2020年06月12日 10:50:00
 */
public class RequestInterceptor extends ModelAndViewMethodReturnValueHandler {

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        ModelAndView mav = (ModelAndView)o;
        String category = nativeWebRequest.getParameter("category");
        if(category==null){
            category="-1";
        }
          mav.addObject("category",Integer.valueOf(category));
        super.handleReturnValue(o,methodParameter,modelAndViewContainer,nativeWebRequest);

    }
}
