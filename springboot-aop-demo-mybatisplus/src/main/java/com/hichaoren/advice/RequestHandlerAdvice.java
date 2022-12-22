package com.hichaoren.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.IOException;
import java.lang.reflect.Type;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by HiChaoRen on 2022-12-15.
 */
@ControllerAdvice
@Slf4j
public class RequestHandlerAdvice extends RequestBodyAdviceAdapter {

    private static final String REQ_KEY = "4957CA66-37C3-46CB-B26D-E3D9DCB51535";

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.debug("RequestHandlerAdvice supports...");
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        log.debug("RequestHandlerAdvice beforeBodyRead...");
        return super.beforeBodyRead(inputMessage, parameter, targetType, converterType);
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.debug("RequestHandlerAdvice afterBodyRead...");
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.debug("RequestHandlerAdvice handleEmptyBody...");
        return super.handleEmptyBody(body, inputMessage, parameter, targetType, converterType);
    }
}
