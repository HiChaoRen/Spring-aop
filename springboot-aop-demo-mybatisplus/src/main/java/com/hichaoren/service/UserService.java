package com.hichaoren.service;

import com.hichaoren.domain.ComponentInfo;
import com.hichaoren.domain.User;

import java.util.List;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
public interface UserService {

    boolean save(User user);

    boolean delete(Integer id);

    boolean update(User user);

    List<User> findAll();

    User findById(Integer id);


    List<ComponentInfo> findAllComponentInfo();
}
