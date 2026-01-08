package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        //1.  Launch Spring application/Context

        /*
         use new try with resources to close the context after use
         if any exception happens in the code the context.close will be automatically called.
         */
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
            // 2. Configure the things we want spring to manage
            // create HelloWorldConfiguration annotated with @Configuration
            // a method annotated with @Bean on it which returns some value based on method type

            //Retrieve beans managed by Spring
            System.out.println("name - " +context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
//        System.out.println(context.getBean("address"));
//        Once spring has beans - can fetch it using bean name or class name

//        No qualifying bean of type 'com.in28minutes.learn_spring_framework.helloworld.Address' available: expected single matching bean but found 2: address2,address3
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean(Person.class));

            System.out.println(context.getBean("person3Parameters"));

            // get all the beans defined in the registry.
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }

    }
}
