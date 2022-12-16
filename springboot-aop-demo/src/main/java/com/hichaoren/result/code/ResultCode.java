package com.hichaoren.result.code;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
public enum ResultCode implements IErrorCode {

    SUCCESS(200, "获取成功"),
    FAILED(500, "网络繁忙，请稍后再试"),
    ;
    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
