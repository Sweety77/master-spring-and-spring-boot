package com.in28minutes.learn_spring_framework.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class RealWorldApplicationLauncher {

    /*private static BusinessCalculationService service;

    public RealWorldApplicationLauncher(BusinessCalculationService service){
        this.service = service;
    }*/

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(RealWorldApplicationLauncher.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

//        System.out.println(service.findMax());

        System.out.println("Max "+context.getBean(BusinessCalculationService.class).findMax());

    }
}
