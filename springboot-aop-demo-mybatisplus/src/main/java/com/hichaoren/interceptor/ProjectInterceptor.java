package com.hichaoren.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
@Component
public class ProjectInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //返回值类型可以拦截控制的执行，true放行，false终止
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("拦截器ProjectInterceptor-----preHandle...");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("拦截器ProjectInterceptor-----postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        String value = response.getHeader("reqData");
//        response.setHeader("reqData","2222222");
//        String value2 = response.getHeader("reqData");
//        System.out.println("afterCompletion ..." +value +value2);
        logger.debug("拦截器ProjectInterceptor-----afterCompletion...");
    }
}
