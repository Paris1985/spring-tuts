package com.example.springtuts.aop;

import com.example.springtuts.Cat;
import com.example.springtuts.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration 
@EnableAspectJAutoProxy
public class AnimalFarmConfig {
    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Bean
    public Cat cat() {
        return new Cat();
    }

    @Bean
    public MethodTimeLoggingAspect timeLoggingAspect() {
        return new MethodTimeLoggingAspect();
    }

    @Bean
    public MethodMessageLoggingAspect loggingAspect() {
        return new MethodMessageLoggingAspect();
    }
}
