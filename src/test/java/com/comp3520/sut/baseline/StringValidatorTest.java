package com.comp3520.sut.baseline;

import com.comp3520.sut.StringValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.ConvertWith;

import static org.junit.jupiter.api.Assertions.*;

public class StringValidatorTest {

    private StringValidator validator;

    @BeforeEach
    public void setUP() {
        validator = new StringValidator();
    }

    @Test
    public void testValidatePassword() {
        assertTrue(validator.validatePassword("Password123"));
    }

    @Test
    public void testValidatePasswordTooShort() {
        assertFalse(validator.validatePassword("Pass1"));
    }

    @Test
    public void testValidatePasswordNoDigit() {
        assertFalse(validator.validatePassword("PasswordOnly"));
    }

    @Test
    public void testValidatePasswordNull() {
        assertFalse(validator.validatePassword(null));
    }

    @Test
    public void testNormalizeslugValid() {
        assertEquals("hello-world-test", validator.normalizeSlug(" Hello World Test "));
    }

    @Test
    public void testNormalizeSlugNullorEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.normalizeSlug("  ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validator.normalizeSlug(null);
        });
    }
}
