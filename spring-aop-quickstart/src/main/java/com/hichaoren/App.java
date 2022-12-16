package com.hichaoren;

import com.hichaoren.config.SpringConfig;
import com.hichaoren.dao.UserDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by HiChaoRen on 2022-12-12.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = context.getBean(UserDao.class);
        userDao.save();
        System.out.println(userDao.getClass());
    }
}
