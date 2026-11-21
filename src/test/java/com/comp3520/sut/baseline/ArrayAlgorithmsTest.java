package com.comp3520.sut.baseline;

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
    public void binarySearchFound() {
        int[] sorted = {2, 5, 8, 12, 16, 23, 38};
        assertEquals(0, algorithms.binarySearch(sorted, 2));
        assertEquals(3, algorithms.binarySearch(sorted, 12));
        assertEquals(6, algorithms.binarySearch(sorted, 38));
    }

    @Test
    public void nullBinarySearch() {
        assertThrows(IllegalArgumentException.class, () ->
                algorithms.binarySearch(null, 5));
    }

    @Test
    public void testFindMax() {
        assertEquals(42, algorithms.findMax(new int[]{10, 42, -3, 25}));
        assertEquals(-5, algorithms.findMax(new int[]{-20, -5, -12}));
    }

    @Test
    public void nullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                algorithms.findMax(null));
        assertThrows(IllegalArgumentException.class, () ->
                algorithms.findMax(new int[]{}));
    }
}
