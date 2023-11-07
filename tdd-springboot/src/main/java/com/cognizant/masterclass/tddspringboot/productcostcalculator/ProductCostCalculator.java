package com.cognizant.masterclass.tddspringboot.productcostcalculator;

public class ProductCostCalculator {

    private final PriceService priceService;

    public ProductCostCalculator(PriceService priceService) {
        this.priceService = priceService;
    }

    public int compute(Order order){
        return order.getQuantity() * priceService.getPrice(order.getProduct());
    }
}
