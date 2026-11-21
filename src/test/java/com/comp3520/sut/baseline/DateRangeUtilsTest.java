package com.comp3520.sut.baseline;

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
    public void invalidLeapYear() {
        assertThrows(IllegalArgumentException.class, () -> dateUtils.isLeapYear(0));
        assertThrows(IllegalArgumentException.class, () -> dateUtils.isLeapYear(-2020));
    }

    @Test
    public void testGetDaysInMonth() {
        assertEquals(31, dateUtils.getDaysInMonth(1, 2024));
        assertEquals(29, dateUtils.getDaysInMonth(2, 2024));
        assertEquals(28, dateUtils.getDaysInMonth(2, 2023));
        assertEquals(30, dateUtils.getDaysInMonth(4, 2024));
        assertEquals(31, dateUtils.getDaysInMonth(12, 2024));
    }

    @Test
    public void invalidMonth() {
        assertThrows(IllegalArgumentException.class, () -> dateUtils.getDaysInMonth(0,2024));
        assertThrows(IllegalArgumentException.class, () -> dateUtils.getDaysInMonth(13, 2024));
    }
}
