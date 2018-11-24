package com.nnikolov.jiradump;

import com.nnikolov.jiradump.enums.OutputType;
import com.nnikolov.jiradump.exception.NoOutputTypeDefinedException;

/**
 * Can process java runtime arguments
 */
public interface ArgProcessor {

    /**
     * Seeks for and returns the first occurrence of an available output
     * type in the runtime arguments
     *
     * @return first occurrence of ana available {@link OutputType}
     * @throws NoOutputTypeDefinedException when null or empty arguments list
     *                                      or no output type found
     */
    OutputType resolveOutputType() throws NoOutputTypeDefinedException;
}
