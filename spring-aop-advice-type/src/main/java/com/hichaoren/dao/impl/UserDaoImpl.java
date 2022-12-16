package com.hichaoren.dao.impl;

import com.hichaoren.dao.UserDao;

import org.springframework.stereotype.Repository;

/**
 * Created by HiChaoRen on 2022-12-12.
 */
@Repository
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("user dao save...");
    }

    public int submit() {
        System.out.println("user dao submit...");
        return 100;
    }
}
