package com.hichaoren.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by HiChaoRen on 2022-12-12.
 */
@Aspect
@Component
public class UserAdvice {

//    @Pointcut("execution(void com.hichaoren.dao..*())")
//    @Pointcut("execution(* *..*(..))")
//    @Pointcut("execution(* com.hichaoren.*.*Dao.save())")
    @Pointcut("execution(void com.hichaoren.dao.impl.UserDaoImpl.save())")
    private void pointCut() {
    }

    @Before("pointCut()")
    public void adviceMethod() {
        System.out.println("do before");
    }

}
