package com.comp3520.sut;

public class InventoryLedger {

    public int updateStock(int currentStock, int quantityChange, int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max capacity must be positive");
        }
        int newStock = currentStock + quantityChange;
        if (newStock < 0) {
            throw new IllegalArgumentException("Stock cannot drop below zero");
        }
        if (newStock > maxCapacity) {
            return maxCapacity;
        }
        return newStock;
    }

    public boolean requiresReorder(int currentStock, int reorderThreshold) {
        if (currentStock < 0 || reorderThreshold < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        }
        return currentStock < reorderThreshold;
    }
}
