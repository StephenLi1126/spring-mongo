package com.stephen.spring.mongo.test;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	  //@Before("execution(public double com.stephen.spring.mongo.test.AddCalculator.getResult(double,double))")
	  @Before("execution(public * com.stephen.spring.mongo.test.*.*(..))")
	  public void beforeExecute(JoinPoint joinPoint){
	      String classname = joinPoint.getTarget().getClass().getSimpleName();
	      String methodName = joinPoint.getSignature().getName();
	      List<Object> args = Arrays.asList(joinPoint.getArgs());
	      System.out.println("before Execute! --class name: " + classname + ", method name: " + methodName + " " + args );
	  }

//    @Before("execution(public * com.stephen.spring.mongo.test.*.*(..))")
//    public void before(JoinPoint joinPoint) {
//        System.out.println("[Aspect2] before advise");
//    }
//
    @Around("execution(public * com.stephen.spring.mongo.test.*.*(..))")
    public double around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("[Aspect2] around advise 1");
        Object[] args = pjp.getArgs();
        pjp.proceed(args);
        Object rvt = pjp.proceed(args);
        System.out.println("[Aspect2] around advise2");
        return (double) rvt;
    }
//
//    @AfterReturning("execution(public * com.stephen.spring.mongo.test.*.*(..))")
//    public void afterReturning(JoinPoint joinPoint) {
//        System.out.println("[Aspect2] afterReturning advise");
//    }
//
//    @AfterThrowing("execution(public * com.stephen.spring.mongo.test.*.*(..))")
//    public void afterThrowing(JoinPoint joinPoint) {
//        System.out.println("[Aspect2] afterThrowing advise");
//    }
//
//    @After("execution(public * com.stephen.spring.mongo.test.*.*(..))")
//    public void after(JoinPoint joinPoint) {
//        System.out.println("[Aspect2] after advise");
//    }
}