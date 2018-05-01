package com.train.bean.conflict;

public class IceCream implements Dessert {

    private String name = IceCream.class.getSimpleName();

    @Override
    public void features() {
        System.out.println(this.getClass().getName());
    }


}
