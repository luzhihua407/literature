package com.aiyo407.literature.interceptor;

import com.aiyo407.literature.enums.ArticleCategoryEnum;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName RequestInterceptor.java
 * @Description TODO
 * @createTime 2020年06月12日 10:50:00
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String category = request.getParameter("category");
        if(category==null){
            request.setAttribute("category",ArticleCategoryEnum.诗词.getValue());
        }
        return true;
    }
}
