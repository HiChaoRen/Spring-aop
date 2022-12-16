package com.hichaoren.result;

import com.hichaoren.result.code.IErrorCode;
import com.hichaoren.result.code.ResultCode;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
@Data
public class Result<T> implements Serializable {

    private Response<T> response;

    private Result(long code, String message, T data) {
        this.response = new Response<>(new Header(code, message), data);
    }

    /**
     * @param <T> 返回体body
     * @return 请求成功统一处理
     */
    public static <T> Result<T> success() {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * @param <T> 返回体body
     * @return 请求失败统一处理
     */
    public static <T> Result<T> failed() {
        return new Result<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null);
    }

    public static <T> Result<T> failed(String message) {
        return new Result<T>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> Result<T> failed(IErrorCode errorCode) {
        return new Result<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

}

