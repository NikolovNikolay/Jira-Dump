package com.nnikolov.jiradump;

import static com.nnikolov.jiradump.ErrorMessages.NO_OUTPUT_TYPE_DEFINED_DEFAULT;

public class NoOutputTypeDefinedException extends Exception {

    public NoOutputTypeDefinedException() {
        super(NO_OUTPUT_TYPE_DEFINED_DEFAULT);
    }
}
