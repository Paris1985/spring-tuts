package com.example.springtuts.bpp;

import com.example.springtuts.Cat;
import com.example.springtuts.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Throwable {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AnimalFarmConfig.class);

        Cat cat = annotationConfigApplicationContext.getBean(Cat.class);
        cat.meow();

        Dog dog = annotationConfigApplicationContext.getBean(Dog.class);
        dog.bark();
    }
}
