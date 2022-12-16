package com.hichaoren.proxy.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by HiChaoRen on 2022-12-13.
 */
public class DynamicCglibProxy implements MethodInterceptor {

    public Object getProxyInstance(Class cla) {
        // 1. 增强类对象
        Enhancer en = new Enhancer();
        // 2. 设置父类
        en.setSuperclass(cla);
        // 3. 设置回调函数
        en.setCallback(this);
        // 4. 创建子类（代理对象）
        return en.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("do  before");
        Object o = methodProxy.invokeSuper(object, args);
        System.out.println("do  after");
        return o;
    }
}
