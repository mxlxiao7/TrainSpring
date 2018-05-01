package com.train.bean.config.code;

import org.springframework.beans.factory.annotation.Autowired;

public class BMW implements Car {

    private String name;

    public BMW(){

    }

    public BMW(String name){
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " move");
    }

    @Autowired
    public String getName() {
        return name;
    }

    @Autowired
    public void setName(String name) {
        this.name = name;
    }
}
