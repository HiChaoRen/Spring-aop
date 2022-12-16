package com.hichaoren.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by HiChaoRen on 2022-12-12.
 */
@ComponentScan("com.hichaoren")
@Configuration
//开启注解开发Aop
@EnableAspectJAutoProxy
public class SpringConfig {
}
