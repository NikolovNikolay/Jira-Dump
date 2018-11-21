package com.nnikolov.jiradump.writers;

public interface Writer {

    void write(String fileName, Object content);
}
