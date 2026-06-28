package com.in28minutes.springboot.learn_spring_boot;
// /course
// id, name, author

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
record Person(String name, int age){}
@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguraton currencyServiceConfiguraton;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguraton retrieveCurrencyConfigurations(){
        return currencyServiceConfiguraton;
    }
}
