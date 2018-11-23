package com.nnikolov.jiradump;

public interface ArgProcessor {

    OutputType resolveOutputType() throws NoOutputTypeDefinedException;
}
