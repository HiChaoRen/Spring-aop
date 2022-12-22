package com.hichaoren.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hichaoren.domain.GetUserReqBody;
import com.hichaoren.domain.User;
import com.hichaoren.exception.BusinessException;
import com.hichaoren.service.UserServiceMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by HiChaoRen on 2022-12-22.
 */
@RestController
@Slf4j
@RequestMapping("/usermp")
public class UserControllerMP {

    @Autowired
    private UserServiceMP serviceMP;

    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        if (user == null) {
            throw new BusinessException("缺少参数");
        }
        boolean isOk = serviceMP.save(user);
        if (!isOk) {
            throw new BusinessException("保存失败");
        }
    }

    @PostMapping("/query")
    public Object findUsers(@RequestBody User user) {
        return serviceMP.query(user);
    }

    @PostMapping("/querypage")
    private Object getPage(@RequestBody GetUserReqBody reqBody) {
        IPage<User> page = serviceMP.getPage(reqBody.getPageIndex(), reqBody.getPageSize());
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (reqBody.getPageIndex() > reqBody.getPageSize()) {
            page = serviceMP.getPage((int) page.getPages(), reqBody.getPageSize());
        }
        return page;
    }

}
