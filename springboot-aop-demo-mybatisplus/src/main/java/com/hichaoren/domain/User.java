package com.hichaoren.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
@Data
//表名与编码开发设计不同步
@TableName("user")
public class User {
    //表字段与编码属性设计不同步
    @TableField(value = "id")
    //设置生成策略为AUTO
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private Double money;
    //编码中添加了数据库中未定义的属性
    @TableField(exist = false)
    private String nickName;
}
