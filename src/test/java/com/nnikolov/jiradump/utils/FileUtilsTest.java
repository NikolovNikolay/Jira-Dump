package com.nnikolov.jiradump.utils;

import org.junit.Test;

import static com.nnikolov.jiradump.utils.FileUtils.createSubDirs;
import static org.junit.Assert.*;

public class FileUtilsTest {

    @Test
    public void testCreateSubDirectories() {
        createSubDirs("gosho", "pesho");
    }
}