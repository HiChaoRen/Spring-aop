package com.hichaoren.result;

import java.io.Serializable;

import lombok.Data;

@Data
public class Response<T> implements Serializable {
    private Header header;
    private T body;

    public Response(Header header, T body) {
        this.header = header;
        this.body = body;
    }
}
