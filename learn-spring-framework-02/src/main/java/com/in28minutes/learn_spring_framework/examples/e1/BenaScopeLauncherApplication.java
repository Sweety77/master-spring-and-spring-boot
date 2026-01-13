package com.in28minutes.learn_spring_framework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
By default all the bean that are created in spring are singleton - which mean same bean return for every request from context.
When we need differenct bean return for every request from context then use Prototype bean type in spring application.
 */




@Component
class NormalClass{

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{

}
@Configuration
@ComponentScan  //if we don't supply package here in ComponentScan, it automatically scans the current package. In this case it is needed to scan the current package so we can remove the package signature.
public class BenaScopeLauncherApplication {

    public static void main(String[] args) {

// var is type inference keyword introduced in Java 10 -> allows compiler to infer the type of the variable based on the value assigned.
// try with resource - if any exception occurs in the try block the context gets closed automatically.
        try(var context = new AnnotationConfigApplicationContext(BenaScopeLauncherApplication.class)) {


            // same bean
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));


        }
    }
}
