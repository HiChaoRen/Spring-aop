package com.hichaoren.dao;

import com.hichaoren.domain.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by HiChaoRen on 2022-12-13.
 */
public interface UserDao {

    @Insert("insert into user(id,name,password,money)values(#{id},#{name},#{password},#{money})")
    void save(User user);

    @Delete("delete from user where id = #{id} ")
    void delete(Integer id);

    @Update("update user set name = #{name} ,password = #{password} ,money = #{money} where id = #{id} ")
    void update(User user);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id} ")
    User findById(Integer id);

}
