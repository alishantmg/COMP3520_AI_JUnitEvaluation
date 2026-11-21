package com.comp3520.sut.baseline;

import com.comp3520.sut.OrderCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderCalculatorTest {

    private OrderCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new OrderCalculator();
    }

    @Test
    public void discountBelow50() {
        assertEquals(40.0, calculator.calculateDiscountedTotal(40.0, false), 0.0001);
        assertEquals(40.0, calculator.calculateDiscountedTotal(40.0, true), 0.0001);
    }

    @Test
    public void discountBetween50And99() {
        assertEquals(76.0, calculator.calculateDiscountedTotal(80.0, false), 0.0001);
        assertEquals(72.0, calculator.calculateDiscountedTotal(80.0, true), 0.0001);
    }

    @Test
    public void discount100OrAbove() {
        assertEquals(180.0, calculator.calculateDiscountedTotal(200.0, false), 0.0001);
        assertEquals(160.0, calculator.calculateDiscountedTotal(200.0, true), 0.0001);
    }

    @Test
    public void negativeSubTotal() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculateDiscountedTotal(-1.0, false));
    }

    @Test
    public void qualifiesFreeShipping() {
        assertFalse(calculator.qualifiesForFreeShipping(-5.0, true));
        assertTrue(calculator.qualifiesForFreeShipping(25.0, true));
        assertFalse(calculator.qualifiesForFreeShipping(24.99, true));
        assertTrue(calculator.qualifiesForFreeShipping(50.0, false));
        assertFalse(calculator.qualifiesForFreeShipping(49.99, false));
    }
}
