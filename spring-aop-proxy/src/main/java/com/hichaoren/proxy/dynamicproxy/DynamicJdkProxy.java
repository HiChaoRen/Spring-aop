package com.hichaoren.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by HiChaoRen on 2022-12-13.
 */
@SuppressWarnings("unchecked")
public class DynamicJdkProxy implements InvocationHandler {
    private Object mTargetObject;

    public Object getProxyInstance(Object targetObject) {
        this.mTargetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do  before ");
        Object result = method.invoke(mTargetObject, args);
        System.out.println("do  after ");
        return result;
    }
}
