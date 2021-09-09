package com.example.springtuts.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MethodMessageLoggingAspect {
    @Around("@annotation(com.example.springtuts.Logged)")
    public Object time(ProceedingJoinPoint invocation) throws Throwable {
        System.out.println("----------------------------------------");
        System.out.println(invocation.getSignature().getName() + " ... running");
        Object result = invocation.proceed(); // call the method
        System.out.println(invocation.getSignature().getName() + " ... completes");
        return result;

    }

}
