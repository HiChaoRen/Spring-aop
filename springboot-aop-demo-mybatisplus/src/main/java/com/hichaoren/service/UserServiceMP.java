package com.hichaoren.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hichaoren.domain.User;

/**
 * Created by HiChaoRen on 2022-12-22.
 */
public interface UserServiceMP extends IService<User> {

    Object query(User user);

    IPage<User> getPage(int currentPage, int pageSize);

    IPage<User> getPage(int currentPage, int pageSize, User user);

}
