package com.in28minutes.learn_spring_framework.examples.a1;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
class YourBusinessClass{

    @Autowired
    Dependency1 dependency1;

    @Autowired
    Dependency2 dependency2;

    @Override
    public String toString() {
        return "YourBusinessClass using " +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2;
    }
}
@Component
class Dependency1{

}
@Component
class Dependency2{

}


@Configuration
@ComponentScan  //if we don't supply package here in ComponentScan, it automatically scans the current package. In this case it is needed to scan the current package so we can remove the package signature.
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));


        }
    }
}
