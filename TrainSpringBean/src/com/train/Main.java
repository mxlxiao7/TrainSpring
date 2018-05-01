package com.train;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){

        //普通方式
        System.out.println("--------普通方式-------");
        HelloWorld h = new HelloWorld();
        h.setName("Spring");
        h.sayHello();


        System.out.println("\n\n--------Spring方式-------");
        //Spring方式
        ApplicationContext context = new ClassPathXmlApplicationContext("com/train/spring-config.xml");

        h = (HelloWorld) context.getBean("helloWorld");
        h.sayHello();

    }
}
