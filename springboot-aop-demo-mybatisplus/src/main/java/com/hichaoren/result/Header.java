package com.hichaoren.result;

import java.io.Serializable;

import lombok.Data;

@Data
public class Header implements Serializable {
    private long rspCode;
    private String rspDesc;
    private long rspTime;

    public Header(long rspCode, String rspDesc) {
        this.rspCode = rspCode;
        this.rspDesc = rspDesc;
        this.rspTime = System.currentTimeMillis();
    }

}
