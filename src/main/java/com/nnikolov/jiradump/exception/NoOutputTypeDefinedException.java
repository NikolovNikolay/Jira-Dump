package com.nnikolov.jiradump.exception;

import static com.nnikolov.jiradump.exception.ExceptionMessages.NO_OUTPUT_TYPE_DEFINED_DEFAULT;

/**
 * Checked exception class thrown where output type is not present in
 * process runtime arguments
 */
public class NoOutputTypeDefinedException extends Exception {

    public NoOutputTypeDefinedException() {
        super(NO_OUTPUT_TYPE_DEFINED_DEFAULT);
    }
}
