package com.train.bean.config.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boeing747 implements Plane {

    private String name = "Boeing747";

    private Tyre tyre;

    @Autowired
    public Boeing747(Tyre tyre) {
        this.tyre = tyre;
    }

    @Autowired
    public void setCompactDisc(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void fly() {
        System.out.println(name + " fly");
    }

    @Override
    public void use() {
        tyre.use();
    }
}
