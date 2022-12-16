package com.hichaoren.proxy;

import com.hichaoren.proxy.dao.UserDao;
import com.hichaoren.proxy.dao.impl.UserDaoImpl;
import com.hichaoren.proxy.dynamicproxy.DynamicCglibProxy;
import com.hichaoren.proxy.dynamicproxy.DynamicJdkProxy;
import com.hichaoren.proxy.staticproxy.StaticProxy;

/**
 * Created by HiChaoRen on 2022-12-13.
 */
public class App {

    public static void main(String[] args) {
        UserDaoImpl target = new UserDaoImpl();
        //静态代理
        UserDao staticProxy = new StaticProxy(target);
        staticProxy.save();
        //jdk 动态代理
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");//将JDK动态代理生成的class文件保存到本地
        DynamicJdkProxy jdkProxy = new DynamicJdkProxy();
        UserDao proxyClass = (UserDao) jdkProxy.getProxyInstance(target);
        System.out.println(proxyClass.getClass());
        proxyClass.save();
        //cglib动态代理
        DynamicCglibProxy cglibProxy = new DynamicCglibProxy();
        UserDaoImpl userDaoImplProxy= (UserDaoImpl) cglibProxy.getProxyInstance(UserDaoImpl.class);
        System.out.println(userDaoImplProxy.getClass());
        userDaoImplProxy.save();
    }
}
