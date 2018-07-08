package com.stephen.spring.mongo.test;

import org.springframework.stereotype.Component;

@Component
public class AddCalculator implements Calculator {

    @Override
    public double getResult(double a, double b) {
        return a + b;
    }
}
