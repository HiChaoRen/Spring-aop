package com.hichaoren.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {

    public static void main(String[] args) throws Exception {
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql1 = "update user set money = money-100 where id = 1";
        String sql2 = "update user set money = money+100 where id = 2";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        try {
            // 开启事务
            conn.setAutoCommit(false);
            //5. 执行sql
            int count1 = stmt.executeUpdate(sql1);//受影响的行数
            //6. 处理结果
            System.out.println(count1);
            //5. 执行sql
            int count2 = stmt.executeUpdate(sql2);//受影响的行数
            //6. 处理结果
            System.out.println(count2);
            if (true){
                throw new RuntimeException();
            }
            // 提交事务
            conn.commit();
        } catch (Exception throwables) {
            // 回滚事务
            conn.rollback();
            throwables.printStackTrace();
        }
        //7. 释放资源
        stmt.close();
        conn.close();
    }
}
