package com.comp3520.sut.structured;

import com.comp3520.sut.InventoryLedger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryLedgerTest {

    private InventoryLedger ledger;

    @BeforeEach
    public void setUp() {
        ledger = new InventoryLedger();
    }

    @Test
    public void updateStockExactBoundary() {
        //max cap reached
        assertEquals(50, ledger.updateStock(30, 20, 50));
        //overflow
        assertEquals(50, ledger.updateStock(45, 25, 50));
        //zero stock remaining allowed
        assertEquals(0, ledger.updateStock(10, -10, 50));
        //zero change
        assertEquals(10, ledger.updateStock(10, 0, 50));
    }

    @Test
    public void belowZeroThrowsIllegalState() {
        assertThrows(IllegalArgumentException.class, () ->
                ledger.updateStock(10, -11, 50));
        assertThrows(IllegalArgumentException.class, () ->
                ledger.updateStock(0, -1, 50));
    }

    @Test
    public void invalidInputThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                ledger.updateStock(10, 5, 0));
        assertThrows(IllegalArgumentException.class, () ->
                ledger.updateStock(10, 5, -10));
    }

    @Test
    public void requiresReorderAndInvalidStock() {
        assertTrue(ledger.requiresReorder(0,10));
        assertTrue(ledger.requiresReorder(9,10));
        assertTrue(ledger.requiresReorder(10,10));
        assertFalse(ledger.requiresReorder(11,10));
        assertThrows(IllegalArgumentException.class, () ->
                ledger.requiresReorder(-1, 10));
        assertThrows(IllegalArgumentException.class, () ->
                ledger.requiresReorder(5, -1));
    }
}
