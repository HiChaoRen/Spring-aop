package com.hichaoren.service;

import com.hichaoren.domain.User;

import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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

    @Transactional
    void transfer(String out, String in , Double money) throws IOException;
}
