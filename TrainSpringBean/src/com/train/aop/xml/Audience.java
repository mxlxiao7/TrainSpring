package com.train.aop.xml;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class Audience {

    public void performance() {
        System.out.println("---------------------------------");
    }

    public void beforePerformance() {
        System.out.println("before performance");
    }

    public void afterPerformance() {
        System.out.println("after performance");
    }

    public void afterReturningPerformance(Object retVal) {
        System.out.println("after returning performance " + retVal.toString());
    }

    public void afterThrowing(IllegalArgumentException ex) {
        System.out.println("after throwing " + ex.getMessage());
    }


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
