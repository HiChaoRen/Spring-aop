package com.hichaoren.dao;

import com.hichaoren.domain.User;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by HiChaoRen on 2022-12-14.
 */
@Mapper
public interface UserDao {

    @Insert("insert into user(name,password,money)values(#{name},#{password},#{money})")
    int save(User user);

    @Delete("delete from user where id = #{id} ")
    int delete(Integer id);

    @Update("update user set name = #{name} ,password = #{password} ,money = #{money} where id = #{id} ")
    int update(User user);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id} ")
    User findById(Integer id);
}
