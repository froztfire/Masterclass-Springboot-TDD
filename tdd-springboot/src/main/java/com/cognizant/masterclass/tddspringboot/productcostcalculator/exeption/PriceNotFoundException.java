package com.cognizant.masterclass.tddspringboot.productcostcalculator.exeption;

public class PriceNotFoundException extends RuntimeException{

    public PriceNotFoundException(String message) {
        super(message);
    }
}
