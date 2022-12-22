package com.hichaoren.exception;

import com.hichaoren.result.Result;
import com.hichaoren.result.code.IErrorCode;
import com.hichaoren.result.code.ResultCode;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
@RestControllerAdvice(basePackages = {"com.hichaoren.controller"})
@Slf4j
public class GlobalExceptionAdvice {


    @ExceptionHandler(BusinessException.class)
    public Result<String> handlerBE(BusinessException businessException) {
        log.error(
                "BusinessException:" +
                        "-----" +
                        "errorCode:" + businessException.getCode() +
                        "-----" +
                        "errorMessage:" + businessException.getMessage());
        return Result.failed(new IErrorCode() {
            @Override
            public long getCode() {
                return businessException.getCode() == null ? -1 : businessException.getCode();
            }

            @Override
            public String getMessage() {
                return businessException.getMessage();
            }
        });
    }

    @ExceptionHandler(SystemException.class)
    public Result<String> handlerSE(SystemException systemException) {
        log.error(
                "SystemException:" +
                        "-----" +
                        "errorCode:" + systemException.getCode() +
                        "-----" +
                        "errorMessage:" + systemException.getMessage());
        //日志记录、通知开发...
        return Result.failed(new IErrorCode() {
            @Override
            public long getCode() {
                return systemException.getCode();
            }

            @Override
            public String getMessage() {
                return systemException.getMessage();
            }
        });
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handlerException(Exception exception) {
        log.error(
                "Exception:" +
                        "-----" +
                        "errorCode:" + ResultCode.FAILED.getCode() +
                        "-----" +
                        "errorMessage:" + ResultCode.FAILED.getMessage());
        return Result.failed();
    }

}
