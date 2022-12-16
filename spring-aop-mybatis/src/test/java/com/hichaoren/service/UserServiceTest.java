package com.hichaoren.service;

import com.hichaoren.config.SpringConfig;
import com.hichaoren.domain.User;
import com.hichaoren.utils.JsonUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by HiChaoRen on 2022-12-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("二师兄");
        user.setMoney(1000.00);
        user.setPassword("99999");
        userService.save(user);
    }

    @Test
    public void testDelete() {
        userService.delete(4);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(2);
        user.setName("三师妹");
        userService.update(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = userService.findAll();
        System.out.println("查询结果：" + JsonUtils.formatJson(JsonUtils.toJson(userList)));
    }

    @Test
    public void testFindById() {
        User user = userService.findById(1);
        System.out.println("查询结果："+ user);
    }
}
