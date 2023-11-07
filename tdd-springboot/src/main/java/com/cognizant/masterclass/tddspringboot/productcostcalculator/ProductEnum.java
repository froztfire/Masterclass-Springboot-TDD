package com.cognizant.masterclass.tddspringboot.productcostcalculator;

import com.cognizant.masterclass.tddspringboot.productcostcalculator.exeption.PriceNotFoundException;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ProductEnum {
    APPLE("Apple", 3),
    MANGO("Mango", 2),
    TOMATO("Tomato", 4);

    private static final Map<String, ProductEnum> PRODUCT_MAP;

    static {
        PRODUCT_MAP =
                Arrays.stream(ProductEnum.values())
                        .collect(Collectors.toMap(s -> s.getProduct(), Function.identity()));
    }

    public static ProductEnum getProductEnum(String product) {
        return Optional.ofNullable(PRODUCT_MAP.get(product))
                .orElseThrow(() -> new PriceNotFoundException(product));
    }

    private String product;
    private int cost;

    ProductEnum(String product, int cost) {
        this.product = product;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getProduct() {
        return product;
    }
}
