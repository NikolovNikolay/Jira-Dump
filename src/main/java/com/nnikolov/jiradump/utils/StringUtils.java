package com.nnikolov.jiradump.utils;

import java.util.concurrent.ThreadLocalRandom;

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

    public static String getSafeString(int length) {
        if (length <= 0) {
            return "";
        }
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sBuilder.append(chars[random.nextInt(0, chars.length)]);
        }
        return sBuilder.toString();
    }

    public static String getRandomLengthString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int length = random.nextInt(10, 500);

        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sBuilder.append(chars[random.nextInt(0, chars.length)]);
        }
        return sBuilder.toString();
    }
}
