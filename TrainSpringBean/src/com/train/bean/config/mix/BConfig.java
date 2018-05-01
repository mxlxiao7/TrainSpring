package com.train.bean.config.mix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BConfig {

    @Bean
    public B b(){
        return new B();
    }

}
