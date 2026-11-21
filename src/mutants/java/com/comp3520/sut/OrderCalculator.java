package com.comp3520.sut;

public class OrderCalculator {

    public double calculateDiscountedTotal(double subtotal, boolean isMember) {
        if (subtotal < 0.0) {
            throw new IllegalArgumentException("Subtotal cannot be negative");
        }
        double discount = 0.0;
        if (subtotal > 100.0) {
            discount = isMember ? 0.20 : 0.10;
        }else if (subtotal >= 50.0) {
            discount = isMember ? 0.10 : 0.05;
        }
        return subtotal * (1.0 - discount);
    }

    public boolean qualifiesForFreeShipping(double orderAmount, boolean isPrimeMember) {
        if (orderAmount < 0.0)
            return false;
        if (isPrimeMember) {
            return orderAmount >= 25.0;
        }
        return orderAmount >= 50.0;
    }

}
