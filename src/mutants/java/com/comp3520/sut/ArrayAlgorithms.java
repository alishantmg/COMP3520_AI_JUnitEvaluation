package com.comp3520.sut;
public class ArrayAlgorithms {
    public int binarySearch(int[] sortedArray, int target) {
        if (sortedArray == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        int low = 0;
        int high = sortedArray.length - 1;
        while (low < high) {
            int mid = low + (high -low) / 2;
            if (sortedArray[mid] == target) {
                return mid;
            } else if (sortedArray[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int findMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
}
