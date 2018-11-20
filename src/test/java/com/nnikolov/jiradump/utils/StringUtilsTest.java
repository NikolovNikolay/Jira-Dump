package com.nnikolov.jiradump.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testIsNotNullWithNull() {

        boolean result = StringUtils.isNotNull(null);
        Assert.assertFalse(result);
    }

    @Test
    public void testIsNotNullWithBlank() {

        boolean result = StringUtils.isNotNull("");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsNotNullWithText() {

        boolean result = StringUtils.isNotNull("Valid text");
        Assert.assertTrue(result);
    }

    @Test
    public void testHasTextWithNull() {

        boolean result = StringUtils.hasText(null);
        Assert.assertFalse(result);
    }

    @Test
    public void testHasTextWithWhitespace() {

        boolean result = StringUtils.hasText(" ");
        Assert.assertFalse(result);
    }

    @Test
    public void testHasTextWithText() {

        boolean result = StringUtils.hasText(" The quick brown fox...");
        Assert.assertTrue(result);
    }
}