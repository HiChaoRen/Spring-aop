//package com.hichaoren.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
///**
// * Created by HiChaoRen on 2022-12-13.
// */
//@Component
//@Aspect
//public class UserAdvice {
//
//    @Pointcut("execution(* com..*Service.*(..))")
//    private void pointCut() {
//    }
//
//    @Around("pointCut()")
//    public void methodTakeTime(ProceedingJoinPoint pjp) throws Throwable {
//        Signature signature = pjp.getSignature();
//        String className = signature.getDeclaringTypeName();
//        String methodName = signature.getName();
//        long start = System.currentTimeMillis();
//        pjp.proceed();
//        long end = System.currentTimeMillis();
//        System.out.println("方法耗时："+ className+"."+methodName+"---->" +((end-start)/1000.0) + "s");
//    }
//}
