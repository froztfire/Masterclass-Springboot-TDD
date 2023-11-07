package com.cognizant.masterclass.tddspringboot.productcostcalculator;

public class PriceService {
    public int getPrice(String product) {
        return ProductEnum.getProductEnum(product).getCost();
    }
}
