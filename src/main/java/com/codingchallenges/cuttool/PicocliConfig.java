package com.codingchallenges.cuttool;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import picocli.spring.PicocliSpringFactory;

@Configuration
public class PicocliConfig {

    @Bean
    public PicocliSpringFactory picocliSpringFactory(ApplicationContext applicationContext) {
        return new PicocliSpringFactory(applicationContext);
    }
}
