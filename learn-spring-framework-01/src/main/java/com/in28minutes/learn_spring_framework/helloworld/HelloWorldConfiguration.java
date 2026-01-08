package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//introduced in JDK 16 - Eliminating verbosity while creating Java Beans.
//“Verbosity refers to the amount of boilerplate code required to define a Java Bean.
/*
Java 16 records significantly reduce verbosity by automatically generating constructors, accessors, and common methods
    like equals, hashCode, and toString.”
    we can have custom methods in records as well
 */
record Person (String name, int age, Address address ){}
record Address(String firstLine, String city){}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Sweety";
    }

    @Bean
    public int age(){
        return 15;
    }

    @Bean
    public Person person(){
        return new Person("Ravi", 25, new Address("10th Ave SW", "Calgary"));
    }


    //create bean using existing bean - by method call
    @Bean
    public Person person2MethodCall(){
        return new Person(name(),age(), address());
    }

    // Create bean using bean name and pass it as parameter to the bean method.
    // here names of the bean are name, age, address3
    @Bean
    public Person person3Parameters(String name, int age, Address address3){
        return new Person(name, age, address3);
    }

    @Bean
    // NO Qualifying bean of type 'com.in28min...Address '
    // available: expected single matching bean but found 2: addredd2, address3
    @Primary
    public Person person4Parameters(String name, int age, Address address){
        return new Person(name, age, address);
    }

    @Bean
    public Person person5qualifier(String name, int age, @Qualifier("address3qualifier") Address address){
        return new Person(name, age, address);
    }

    @Bean(name = "address2")// give different name to the bean which generally be the actual name of the method, use name attribute.
    @Primary
    public Address address(){
        return new Address("10th Ave SW", "Calgary");
    }

    @Bean(name = "address3")// give different name to the bean which generally be the actual name of the method, use name attribute.
    @Qualifier("address3qualifier")
    public Address address3(){
        return new Address("10th Ave SW", "Calgary");
    }
}
