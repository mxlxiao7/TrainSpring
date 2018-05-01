package com.train.aop;

import com.train.aop.Performance;
import org.springframework.stereotype.Component;

@Component
public class Artist implements Performance {

    private String name = "郭德纲";

    @Override
    public String perform() {
        System.out.println(name + "  perform()");
        return name;
    }

}
