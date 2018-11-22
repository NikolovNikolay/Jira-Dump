package com.nnikolov.jiradump.utils;

/**
 * Util methods for working with strings
 */
public abstract class StringUtils {

    private StringUtils() {
    }

    public static boolean isNotNull(String text) {
        return text != null;
    }

    public static boolean hasText(String text) {
        return isNotNull(text) && text.trim().length() > 0;
    }

}
