package com.comp3520.sut.structured;

import com.comp3520.sut.DateRangeUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateRangeUtilsTest {

    private DateRangeUtils dateUtils;

    @BeforeEach
    public void setUP() {
        dateUtils = new DateRangeUtils();
    }

    @Test
    public void leapYearDivisibility(){
        //divisible by 400
        assertTrue(dateUtils.isLeapYear(2000));
        assertTrue(dateUtils.isLeapYear(1600));

        //divisible by 100 but not 400
        assertFalse(dateUtils.isLeapYear(1900));
        assertFalse(dateUtils.isLeapYear(2100));

        //divisible by 4 but not 100
        assertTrue(dateUtils.isLeapYear(2024));
        assertTrue(dateUtils.isLeapYear(4));

        //not divisible by 4
        assertFalse(dateUtils.isLeapYear(2023));
        assertFalse(dateUtils.isLeapYear(1));
    }

    @Test
    public void isInvalidLeapYear() {
        assertThrows(IllegalArgumentException.class, () -> dateUtils.isLeapYear(0));
        assertThrows(IllegalArgumentException.class, () -> dateUtils.isLeapYear(-2020));
    }

    @Test
    public void getDaysInMonthAll() {
        //31-day months
        assertEquals(31, dateUtils.getDaysInMonth(1, 2024));
        assertEquals(31, dateUtils.getDaysInMonth(3, 2024));
        assertEquals(31, dateUtils.getDaysInMonth(5, 2024));
        assertEquals(31, dateUtils.getDaysInMonth(7, 2024));
        assertEquals(31, dateUtils.getDaysInMonth(8, 2024));
        assertEquals(31, dateUtils.getDaysInMonth(10, 2024));
        assertEquals(31, dateUtils.getDaysInMonth(12, 2024));

        //30-day
        assertEquals(30, dateUtils.getDaysInMonth(4, 2024));
        assertEquals(30, dateUtils.getDaysInMonth(6, 2024));
        assertEquals(30, dateUtils.getDaysInMonth(9, 2024));
        assertEquals(30, dateUtils.getDaysInMonth(11, 2024));

        //feb
        assertEquals(29, dateUtils.getDaysInMonth(2, 2024));
        assertEquals(29, dateUtils.getDaysInMonth(2, 2000));
        assertEquals(28, dateUtils.getDaysInMonth(2, 1900));
        assertEquals(28, dateUtils.getDaysInMonth(2, 2023));
    }

    @Test
    public void invalidMonthAndYear() {
        assertThrows(IllegalArgumentException.class, () -> dateUtils.getDaysInMonth(0,2024));
        assertThrows(IllegalArgumentException.class, () -> dateUtils.getDaysInMonth(13, 2024));
        assertThrows(IllegalArgumentException.class, () -> dateUtils.getDaysInMonth(-1,2024));
        assertThrows(IllegalArgumentException.class, () -> dateUtils.getDaysInMonth(2, 0));
    }
}
