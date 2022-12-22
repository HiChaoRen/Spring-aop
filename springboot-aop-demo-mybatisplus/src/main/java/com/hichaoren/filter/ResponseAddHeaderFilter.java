package com.hichaoren.filter;

import com.hichaoren.utils.JsonUtils;
import com.hichaoren.utils.MD5;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
@Component
@Slf4j
public class ResponseAddHeaderFilter extends OncePerRequestFilter {

    private static final String RES_KEY = "9421B33C-E398-4039-87E8-B46DC3C26E74";
    private static final String HEADER_REQ_DATA = "reqdata";
    private static final String SEC_VERSION = "4";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.debug("过滤器ResponseHeaderFilter-----before...");
        ResponseWrapper wrapper = new ResponseWrapper(response);
        filterChain.doFilter(request, wrapper);
        byte[] data = wrapper.toByteArray();
        String responseStr = new String(data, StandardCharsets.UTF_8);
        response.setContentType("text/plain;charset=utf-8");
        response.setHeader("secver", SEC_VERSION);
        response.setHeader("sec-ver", SEC_VERSION);
        response.setHeader(HEADER_REQ_DATA,MD5.getMD5(responseStr + RES_KEY));
        log.debug("请求地址：" + request.getRequestURL() + "返回结果：\n" + JsonUtils.formatJson(responseStr));
        ServletOutputStream os = response.getOutputStream();
        os.write(data);
        os.flush();
        os.close();
        log.debug("过滤器ResponseHeaderFilter-----after...");
    }


}
