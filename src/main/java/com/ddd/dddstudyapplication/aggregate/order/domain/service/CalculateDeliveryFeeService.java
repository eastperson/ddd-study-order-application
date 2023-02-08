package com.ddd.dddstudyapplication.aggregate.order.domain.service;

public class CalculateDeliveryFeeService {

    private final static Double DELIVERY_FEE = 50_000.0;

    public static Double calculateDeliveryFee(Double productPrice, Long quantity) {
        double totalPrice = productPrice * quantity;
        if (totalPrice > 50_000) {
            totalPrice += DELIVERY_FEE;
        }
        return totalPrice;
    }
}
