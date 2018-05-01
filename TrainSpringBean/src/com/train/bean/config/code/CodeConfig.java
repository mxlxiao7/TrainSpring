package com.train.bean.config.code;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CodeConfig {

    @Bean
    public Car BMW(){
        return new BMW();
    }

}
