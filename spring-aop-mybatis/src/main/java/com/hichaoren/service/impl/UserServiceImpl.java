package com.hichaoren.service.impl;

import com.hichaoren.dao.UserDao;
import com.hichaoren.domain.User;
import com.hichaoren.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by HiChaoRen on 2022-12-13.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public void delete(Integer id) {
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Integer id) {
        return userDao.findById(id);
    }

    public void transfer(String out, String in, Double money) throws IOException {
        userDao.outMoney(out, money);
                int i = 1/0;
        userDao.inMoney(in, money);
    }
}
