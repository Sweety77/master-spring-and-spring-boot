package com.in28minutes.learn_spring_framework.examples.c1;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {

    private static DataService service;

    public BusinessCalculationService(DataService service) {
        this.service = service;
    }
    public int findMax(){
        return Arrays.stream(service.retrieveData()).max().orElse(0);
    }

}
