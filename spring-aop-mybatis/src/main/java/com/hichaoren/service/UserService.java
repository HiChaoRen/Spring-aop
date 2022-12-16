package com.hichaoren.service;

import com.hichaoren.domain.User;

import java.util.List;

/**
 * Created by HiChaoRen on 2022-12-13.
 */
public interface UserService {

    void save(User user);

    void delete(Integer id);

    void update(User user);

    List<User> findAll();

    User findById(Integer id);
}
