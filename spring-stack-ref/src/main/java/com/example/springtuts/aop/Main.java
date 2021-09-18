package com.example.springtuts.aop;

import com.example.springtuts.Cat;
import com.example.springtuts.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		Cat cat = context.getBean(Cat.class);
		Dog dog = context.getBean(Dog.class);

		cat.meow();
		dog.bark();

	}

}
