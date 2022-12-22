package com.hichaoren.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Created by HiChaoRen on 2022-12-15.
 */
public class ResponseWrapper extends HttpServletResponseWrapper {

    private final ByteArrayOutputStream buffer;
    private final ServletOutputStream output;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        buffer = new ByteArrayOutputStream();
        output = new ServletOutputStream() {

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setWriteListener(WriteListener listener) {

            }

            @Override
            public void write(int b) {
                buffer.write(b);
            }
        };
    }


    /**
     * @return 将ServletOutputStream放到公共变量，解决不能多次读写问题
     */
    @Override
    public ServletOutputStream getOutputStream() {
        return output;
    }

    public byte[] toByteArray() throws IOException {
        flushBuffer();
        return buffer.toByteArray();
    }

    @Override
    public void flushBuffer() throws IOException {
        output.flush();
    }
}
