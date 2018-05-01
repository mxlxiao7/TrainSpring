package com.train.bean.conflict;

public class Cake implements Dessert{

    private String name = Cake.class.getSimpleName();

    @Override
    public void features() {
        System.out.println(this.getClass().getName());
    }
}
