package com.train.bean.conflict;

public class Cookies implements Dessert {
    private String name = Cookies.class.getSimpleName();

    @Override
    public void features() {
        System.out.println(this.getClass().getName());
    }
}
