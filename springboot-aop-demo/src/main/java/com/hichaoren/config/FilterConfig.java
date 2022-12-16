package com.hichaoren.config;

import com.hichaoren.filter.ResponseAddHeaderFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HiChaoRen on 2022-12-15.
 */
@Configuration
public class FilterConfig {

    @Autowired
    private ResponseAddHeaderFilter responseAddHeaderFilter;
//    @Autowired
//    private ProjectFilter projectFilter;
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean1() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(projectFilter);
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setOrder(1);//order的数值越小 则优先级越高
//        return filterRegistrationBean;
//    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(responseAddHeaderFilter);
        filterRegistrationBean.addUrlPatterns("/user/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

}
