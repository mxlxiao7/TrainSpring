package com.train.bean.config.xml;

public class Gun {

    private String name;

    public Gun() {

    }

    public void shoot() {
        System.out.println(name + " shooting");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
