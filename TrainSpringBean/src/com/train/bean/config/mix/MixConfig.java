package com.train.bean.config.mix;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


@Configuration
@Import(A.class)
@ImportResource(value = {"classpath:/com/train/bean/mix/c-config.xml"})
public class MixConfig {

    @Bean
    public D d(A a, C c) {
        return new D(a, c);
    }

}
