package com.hichaoren.proxy.dao.impl;

import com.hichaoren.proxy.dao.UserDao;

/**
 * Created by HiChaoRen on 2022-12-13.
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("user dao save ...");
    }

    @Override
    public void update() {
        System.out.println("user dao update ...");
    }
}
