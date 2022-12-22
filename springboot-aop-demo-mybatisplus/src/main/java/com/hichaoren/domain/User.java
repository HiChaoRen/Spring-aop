package com.hichaoren.domain;

import lombok.Data;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Double money;
}
