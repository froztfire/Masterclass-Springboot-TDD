package com.cognizant.masterclass.tddspringboot.productcostcalculator;

import com.cognizant.masterclass.tddspringboot.productcostcalculator.exeption.PriceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductCostCalculatorTest {

    private ProductCostCalculator productCostCalculator;
    private PriceService priceService;

    @BeforeEach
    void init() {
        priceService = new PriceService();
        productCostCalculator = new ProductCostCalculator(priceService);
    }

    @Test
    void shouldReturn6pesosFor3Apples(){
        Order order = new Order("Apple", 2);
        int actual = productCostCalculator.compute(order);

        assertEquals(6, actual);
    }

    @Test
    void shouldReturnPriceFor3Mangoes(){
        Order order = new Order("Mango", 3);
        int actual = productCostCalculator.compute(order);

        assertEquals(6, actual);
    }

    @Test
    void shouldReturnPriceFor3Tomato(){
        Order order = new Order("Tomato", 2);

        int actual = productCostCalculator.compute(order);

        assertEquals(8, actual);
    }

    @Test
    void shouldReturnFailForProductUnavailable() {
        Order order = new Order("Avocado", 2);

        assertThrows(PriceNotFoundException.class, () -> productCostCalculator.compute(order));
    }
}
