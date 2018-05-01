package com.train.aop.code;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(* com.train.aop.Artist.*(..))")
    public void performance() {
        System.out.println("---------------------------------");
    }

    @Before("performance()")
    public void beforePerformance() {
        System.out.println("before performance");
    }

    @After("performance()")
    public void afterPerformance() {
        System.out.println("after performance");
    }

    @AfterReturning(value = "performance()", returning = "retVal")
    public void afterReturningPerformance(Object retVal) {
        System.out.println("after returning performance " + retVal.toString());
    }

    @AfterThrowing(value = "performance()", throwing = "ex")
    public void afterThrowing(IllegalArgumentException ex) {
        System.out.println("after throwing " + ex.getMessage());
    }

    @Around("performance()")
    public Object watchPerformance(ProceedingJoinPoint point) {
        try {
            System.out.println("around watchPerformance before");
            Object name = point.proceed();
            System.out.println("around watchPerformance after");
            return name;
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        return "error";
    }

}
