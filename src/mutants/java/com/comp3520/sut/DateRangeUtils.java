package com.comp3520.sut;

public class DateRangeUtils {

    public boolean isLeapYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be positive");
        }
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }

    public int getDaysInMonth(int month, int year) {
        if (month < 1 || month < 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }
}
