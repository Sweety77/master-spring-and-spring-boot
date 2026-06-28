package com.nt.BusinessCalculationService.service;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] {1,2,3,4,5};
    }

    @Override
    public String toString() {
        return "MySQLDataService{}";
    }
}
