package com.hichaoren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hichaoren.dao.UserDaoMP;
import com.hichaoren.domain.User;
import com.hichaoren.service.UserServiceMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by HiChaoRen on 2022-12-22.
 */
@Service
public class UserServiceImplMP extends ServiceImpl<UserDaoMP, User> implements UserServiceMP {


    @Autowired
    private UserDaoMP userDao;

    @Override
    public Object query(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (user.getId() != null) {
            wrapper.eq(User::getId, user.getId());
        }
        if (user.getName() != null) {
            wrapper.eq(User::getName, user.getName());
        }
        //根据字段来升序
        wrapper.orderByAsc(User::getMoney);
        return userDao.selectList(wrapper);
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage<User> page = new Page<>(currentPage, pageSize);
        return userDao.selectPage(page, null);
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize, User user) {
        return null;
    }
}
