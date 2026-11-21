package com.comp3520.sut.structured;

import com.comp3520.sut.ArrayAlgorithms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayAlgorithmsTest {

    private ArrayAlgorithms algorithms;

    @BeforeEach
    public void setUp() {
        algorithms = new ArrayAlgorithms();
    }

    @Test
    public void binarySearch() {
        int[] single = {42};
        assertEquals(0, algorithms.binarySearch(single, 42));
        assertEquals(-1, algorithms.binarySearch(single, 99));

        int[] sorted = {1, 4, 9, 16, 25, 36, 49};
        assertEquals(0, algorithms.binarySearch(sorted, 1));
        assertEquals(3, algorithms.binarySearch(sorted, 16));
        assertEquals(6, algorithms.binarySearch(sorted, 49));
    }

    @Test
    public void missingAndEmptyArray() {
        int[] sorted = {10, 20, 30, 40};
        assertEquals(-1, algorithms.binarySearch(sorted, 5));
        assertEquals(-1, algorithms.binarySearch(sorted, 25));
        assertEquals(-1, algorithms.binarySearch(sorted, 50));
        assertEquals(-1, algorithms.binarySearch(new int[]{}, 10));
    }


    @Test
    public void binarySearchNull() {
        assertThrows(IllegalArgumentException.class, () ->
                algorithms.binarySearch(null, 10));
    }

    @Test
    public void findMaxElement() {
        assertEquals(7, algorithms.findMax(new int[]{7}));
        assertEquals(-7, algorithms.findMax(new int[]{-7}));
        assertEquals(100, algorithms.findMax(new int[]{100, 20, 50}));
        assertEquals(100, algorithms.findMax(new int[]{20, 50, 100}));
        assertEquals(-1, algorithms.findMax(new int[]{-50, -1, -25}));
    }

    @Test
    public void nullOrEmptyThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                algorithms.findMax(null));
        assertThrows(IllegalArgumentException.class, () ->
                algorithms.findMax(new int[]{}));
    }
}

