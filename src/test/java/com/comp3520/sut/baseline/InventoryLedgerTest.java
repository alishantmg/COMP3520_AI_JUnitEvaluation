package com.comp3520.sut.baseline;

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
    public void updateStockNormal() {
        assertEquals(15, ledger.updateStock(10, 5, 50));
        assertEquals(7, ledger.updateStock(10, -3, 50));
    }

    @Test
    public void updateMaxCapacity() {
        assertEquals(50, ledger.updateStock(40, 25, 50));
    }

    @Test
    public void belowZeroThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                ledger.updateStock(5, -10, 50));
    }

    @Test
    public void invalidCapacityThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                ledger.updateStock(10, 5, 0));
    }

    @Test
    public void requiresReorder() {
        assertTrue(ledger.requiresReorder(5,10));
        assertTrue(ledger.requiresReorder(10,10));
        assertFalse(ledger.requiresReorder(11,10));
        assertThrows(IllegalArgumentException.class, () ->
                ledger.requiresReorder(-1, 10));
    }
}
