package com.hichaoren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hichaoren.domain.User;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by HiChaoRen on 2022-12-22.
 */
@Mapper
public interface UserDaoMP extends BaseMapper<User> {
}
