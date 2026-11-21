package com.comp3520.sut.structured;

import com.comp3520.sut.StringValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringValidatorTest {

    private StringValidator validator;

    @BeforeEach
    public void setUP() {
        validator = new StringValidator();
    }

    @Test
    public void validatePasswordBoundary() {
        assertTrue(validator.validatePassword("Abcdefg1"));
        assertTrue(validator.validatePassword("ValidPass99!"));
    }

    @Test
    public void passwordBelowMin() {
        assertFalse(validator.validatePassword("Pass1"));
        assertFalse(validator.validatePassword(""));
    }

    @Test
    public void specialCharsOnly() {
        assertFalse(validator.validatePassword("PasswordOnly"));
        assertFalse(validator.validatePassword("1234567"));
        assertFalse(validator.validatePassword(null));
    }

    @Test
    public void slugFormatting() {
        assertEquals("hello-world", validator.normalizeSlug("Hello World"));
        assertEquals("hello-world", validator.normalizeSlug("   Hello   World  "));
        assertEquals("abc-123", validator.normalizeSlug("\tAbC\n123 "));
    }

    @Test
    public void invalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.normalizeSlug(" ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validator.normalizeSlug(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validator.normalizeSlug("  \t\n  ");
        });
    }
}

