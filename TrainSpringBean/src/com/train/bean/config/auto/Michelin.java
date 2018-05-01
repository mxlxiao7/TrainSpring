package com.train.bean.config.auto;

import org.springframework.stereotype.Component;

@Component
public class Michelin implements Tyre {

    private String name = "Michelin";

    @Override
    public void use() {
        System.out.println("Use " + name);
    }
}
