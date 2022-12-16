package com.hichaoren.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by HiChaoRen on 2022-12-12.
 */
@Aspect
@Component
public class UserAdvice {

    @Pointcut("execution(* com.hichaoren.dao.UserDao.submit())")
    private void ptTest() {

    }

//    @Before("ptTest()")
    public void before() {
        System.out.println("before advice ...");
    }

//    @After("ptTest()")
    public void after() {
        System.out.println("after advice ...");
    }

//    @Around("ptTest()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...");
        //表示对原始操作的调用
        Integer ret = (Integer) pjp.proceed();
        System.out.println("around after advice ...");
        return ret;
    }

//    @AfterReturning("ptTest()")
    public void afterReturning() {
        System.out.println("afterReturning advice ...");
    }

//    @AfterThrowing("ptTest()")
    public void afterThrowing() {
        System.out.println("afterThrowing advice ...");
    }

}
