package com.nt.BusinessCalculationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {

    private DataService dataService;

    // USing Primary DataService
   /* @Autowired
    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }*/

    // USing Qualifier to inject specific bean
     @Autowired
    public BusinessCalculationService(@Qualifier("mySQLDataService") DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

    @Override
    public String toString() {
        return "BusinessCalculationService{" +
                "dataService=" + dataService +
                '}';
    }
}
