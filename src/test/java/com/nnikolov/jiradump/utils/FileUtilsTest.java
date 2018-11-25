package com.nnikolov.jiradump.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static com.nnikolov.jiradump.utils.FileUtils.createSubDirectories;

public class FileUtilsTest {

    @Test
    public void testCreateSubDirectories() {
        createSubDirectories("outerDirectory", "innerDirectory");

        File outer = new File("outerDirectory");
        Assert.assertTrue(outer.exists() && outer.isDirectory());
        File inner = new File(outer, "innerDirectory");
        Assert.assertTrue(inner.exists() && inner.isDirectory());
        inner.delete();
        outer.delete();
    }
}