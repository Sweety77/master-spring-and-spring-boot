package com.in28minutes.learn_spring_framework.game;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {

// var is type inference keyword introduced in Java 10 -> allows compiler to infer the type of the variable based on the value assigned.
// try with resource - if any exception occurs in the try block the context gets closed automatically.
        try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {

//            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();

        }
    }
}
