package com.hichaoren.proxy.staticproxy;

import com.hichaoren.proxy.dao.UserDao;

/**
 * Created by HiChaoRen on 2022-12-13.
 */
public class StaticProxy implements UserDao {

    private final UserDao userDao;

    public StaticProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("do  before ");
        userDao.save();
        System.out.println("do  after ");
    }

    @Override
    public void update() {
        userDao.update();
    }
}
