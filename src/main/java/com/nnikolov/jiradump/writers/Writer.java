package com.nnikolov.jiradump.writers;

/**
 * File writer. Takes generic content, serialized it to specific
 * structure and saves it to a file.
 */
public interface Writer {

    /**
     * Writes content to file
     *
     * @param fileName    name of the new file
     * @param contentType the content class
     * @param content     generic content to write
     */
    void write(String fileName, Class<?> contentType, Object content);
}
