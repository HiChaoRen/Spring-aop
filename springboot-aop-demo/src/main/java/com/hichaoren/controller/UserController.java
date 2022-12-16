package com.hichaoren.controller;

import com.hichaoren.domain.GetUserReqBody;
import com.hichaoren.domain.User;
import com.hichaoren.exception.BusinessException;
import com.hichaoren.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        log.debug("test running ...");
        return "1";
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        if (user == null) {
            throw new BusinessException("缺少参数");
        }
        boolean isOk = userService.save(user);
        if (!isOk) {
            throw new BusinessException("保存失败");
        }
    }

    @PostMapping("/delete")
    public void delete(@RequestBody GetUserReqBody reqBody) {
        userService.delete(reqBody.getId());
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        List<User> userList = userService.findAll();
        if (userList == null) {
            throw new BusinessException("获取失败");
        }
        return userList;
    }

    @GetMapping("/get/{id}")
    public User getRestfulById(@PathVariable Integer id) {
        return  userService.findById(id);
    }

    @RequestMapping("/getUser")
    public User getById(@RequestParam Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/get")
    public User getById(@RequestBody GetUserReqBody reqBody) {
        if (reqBody == null || reqBody.getId() <= 0) {
            throw new BusinessException(-1, "缺少参数，请检查");
        }
        User user = userService.findById(reqBody.getId());
        return user;
    }

}
