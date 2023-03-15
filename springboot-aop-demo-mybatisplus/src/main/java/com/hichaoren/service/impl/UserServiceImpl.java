package com.hichaoren.service.impl;

import com.hichaoren.dao.UserDao;
import com.hichaoren.domain.ComponentInfo;
import com.hichaoren.domain.User;
import com.hichaoren.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User user) {
        return userDao.save(user) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id) > 0;
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user) > 0;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<ComponentInfo> findAllComponentInfo() {
        return userDao.findAllComponent();
    }
}
