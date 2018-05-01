package com.train.aop.code;


import com.train.aop.Artist;
import com.train.aop.Performance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AudienceConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public Performance performance() {
        return new Artist();
    }

}
