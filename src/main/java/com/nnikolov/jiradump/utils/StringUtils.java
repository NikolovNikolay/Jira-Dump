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

    /**
     * Generates a random content string. If length parameter is null then
     * a random length will be generated as well.
     *
     * @param length target length
     * @return random content string between 10 and 500 characters
     */
    public static String getRandomContentString(Integer length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ".toCharArray();
        ThreadLocalRandom random = ThreadLocalRandom.current();

        if (length == null) {
            length = random.nextInt(10, 500);
        }

        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sBuilder.append(chars[random.nextInt(0, chars.length)]);
        }
        return sBuilder.toString();
    }
}
