package com.hichaoren.advice;

import java.lang.annotation.*;

/**
 * Created by HiChaoRen on 2022-12-16.
 */

/**
 * 返回放行注解
 * 在类和方法上使用此注解表示不会在ResponseResult类中进一步封装返回值，直接返回原生值
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseNotIntercept {
    String value() default "";
}
