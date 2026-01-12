package com.in28minutes.learn_spring_framework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
@ComponentScan  //if we don't supply package here in ComponentScan, it automatically scans the current package. In this case it is needed to scan the current package so we can remove the package signature.
public class SimpleSpringContextApplicationLauncher {

    public static void main(String[] args) {

// var is type inference keyword introduced in Java 10 -> allows compiler to infer the type of the variable based on the value assigned.
// try with resource - if any exception occurs in the try block the context gets closed automatically.
        try(var context = new AnnotationConfigApplicationContext(SimpleSpringContextApplicationLauncher.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);


        }
    }
}
