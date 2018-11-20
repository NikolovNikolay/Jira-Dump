package com.nnikolov.jiradump;

import org.junit.Assert;
import org.junit.Test;

public class EnvConfigTest {

    @Test
    public void testSingletonNotNull() {
        Assert.assertNotNull(EnvConfig.get());
    }
}