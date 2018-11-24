package com.nnikolov.jiradump.writers;

import java.io.File;

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
     * @return created file
     */
    File write(String fileName, Class<?> contentType, Object content);

    /**
     * Extension of the newly created file
     *
     * @return extenion string preceded by a ".", e.g. ".json", ".xml"l
     */
    String getExtension();

    /**
     * @return path for output directory
     */
    String getOutputDirPath();
}
