package com.comp3520.sut.structured;

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
    public void discountZeroAndBelow50() {
        assertEquals(0.0, calculator.calculateDiscountedTotal(0.0, false), 0.0001);
        assertEquals(0.0, calculator.calculateDiscountedTotal(0.0, true), 0.0001);
        assertEquals(49.99, calculator.calculateDiscountedTotal(49.99, false), 0.0001);
        assertEquals(49.99, calculator.calculateDiscountedTotal(49.99, true), 0.0001);
    }

    @Test
    public void discount50To99() {
        //lower boundary
        assertEquals(47.5, calculator.calculateDiscountedTotal(50.0, false), 0.0001);
        assertEquals(45.0, calculator.calculateDiscountedTotal(50.0, true), 0.0001);

        //upper boundary
        assertEquals(94.9905, calculator.calculateDiscountedTotal(99.99, false), 0.0001);
        assertEquals(89.991, calculator.calculateDiscountedTotal(99.99, true), 0.0001);
    }

    @Test
    public void discountTotal100OrAbove() {
        assertEquals(90.0, calculator.calculateDiscountedTotal(100.0, false), 0.0001);
        assertEquals(80.0, calculator.calculateDiscountedTotal(100.0, true), 0.0001);
    }

    @Test
    public void negativeSubTotalThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculateDiscountedTotal(-0.01, false));
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculateDiscountedTotal(-50.0, true));
    }

    @Test
    public void freeShipping() {
        //threshold 25.0
        assertFalse(calculator.qualifiesForFreeShipping(24.99, true));
        assertTrue(calculator.qualifiesForFreeShipping(25.0, true));

        //threshold 50.0
        assertFalse(calculator.qualifiesForFreeShipping(49.99, false));
        assertTrue(calculator.qualifiesForFreeShipping(50.0, false));

        //invalid subtotal
        assertFalse(calculator.qualifiesForFreeShipping(-0.01, true));
        assertFalse(calculator.qualifiesForFreeShipping(-0.01, false));
    }
}

