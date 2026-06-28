package com.nt.BusinessCalculationService.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MongoDBDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] {11,22,33,44,55};
    }

    @Override
    public String toString() {
        return "MongoDBDataService{}";
    }
}
