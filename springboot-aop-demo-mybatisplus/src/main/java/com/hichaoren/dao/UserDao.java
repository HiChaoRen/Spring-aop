package com.hichaoren.dao;

import com.hichaoren.domain.ComponentInfo;
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

    @Select("SELECT a.id, a.name , a.desc , a.mvnGroup , a.mvnArtifact , a.type ,a.componentId, a.groupName, c.userId as maintainerId, b.cName as maintainer , d.version, d.publishTime, CONCAT(e.version, '-SNAPSHOT') as snapshotVersion, e.publishTime as snapshotPublishTime FROM exo_component a LEFT JOIN exo_comp_user c ON a.id = c.cpId  LEFT JOIN exo_user b ON b.id = c.userId LEFT JOIN (SELECT * FROM exo_comp_artifact WHERE publishTime IN (SELECT max(publishTime) FROM exo_comp_artifact WHERE isSnapshot = 0 and version not like '%-hotfix' GROUP BY cpId)) d ON a.id = d.cpId LEFT JOIN (SELECT * FROM exo_comp_artifact WHERE publishTime IN (SELECT max(publishTime) FROM exo_comp_artifact WHERE isSnapshot = 1 GROUP BY cpId)) e ON a.id = e.cpId ORDER BY a.updateTime desc")
    List<User> findAll();

    @Select("select * from user where id = #{id} ")
    User findById(Integer id);



    @Select("SELECT a.id, a.name , a.desc , a.mvnGroup , a.mvnArtifact , a.type ,a.componentId, a.groupName, c.userId as maintainerId, b.cName as maintainer , d.version, d.publishTime, CONCAT(e.version, '-SNAPSHOT') as snapshotVersion, e.publishTime as snapshotPublishTime FROM exo_component a LEFT JOIN exo_comp_user c ON a.id = c.cpId  LEFT JOIN exo_user b ON b.id = c.userId LEFT JOIN (SELECT * FROM exo_comp_artifact WHERE publishTime IN (SELECT max(publishTime) FROM exo_comp_artifact WHERE isSnapshot = 0 and version not like '%-hotfix' GROUP BY cpId)) d ON a.id = d.cpId LEFT JOIN (SELECT * FROM exo_comp_artifact WHERE publishTime IN (SELECT max(publishTime) FROM exo_comp_artifact WHERE isSnapshot = 1 GROUP BY cpId)) e ON a.id = e.cpId ORDER BY a.updateTime desc")
    List<ComponentInfo> findAllComponent();
}
