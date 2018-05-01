package com.train;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloWorld implements
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        BeanPostProcessor,
        DisposableBean {

    private String name;

    public HelloWorld() {
        System.out.println("cons ");
    }

    public HelloWorld(String name) {
        System.out.println("cons " + name);
        this.name = name;
    }

    public String getName() {
        System.out.println("getName() " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("setName() " + name);
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello " + name);
    }

    /**
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware -> setBeanName() " + s);
    }

    /**
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware -> setBeanFactory() ");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware -> setApplicationContext() ");
    }


    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor -> postProcessBeforeInitialization() ");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor -> postProcessAfterInitialization() ");
        return null;
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean -> destroy() ");
    }
}
