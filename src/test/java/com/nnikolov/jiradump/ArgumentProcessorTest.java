package com.nnikolov.jiradump;

import com.nnikolov.jiradump.enums.OutputType;
import com.nnikolov.jiradump.exception.NoOutputTypeDefinedException;
import org.junit.Assert;
import org.junit.Test;

public class ArgumentProcessorTest {

    @Test(expected = NoOutputTypeDefinedException.class)
    public void testResolveOutputTypeNullArguments() throws NoOutputTypeDefinedException {

        String[] args = null;
        ArgProcessor argProcessor = new ArgumentProcessor(args);
        argProcessor.resolveOutputType();
    }

    @Test(expected = NoOutputTypeDefinedException.class)
    public void testResolveOutputTypeEmptyArguments() throws NoOutputTypeDefinedException {

        String[] args = {};
        ArgProcessor argProcessor = new ArgumentProcessor(args);
        argProcessor.resolveOutputType();
    }

    @Test
    public void testResolveOutputTypeValidArguments_1() throws NoOutputTypeDefinedException {

        String[] args = {"json", "xml", "json"};
        ArgProcessor argProcessor = new ArgumentProcessor(args);
        Assert.assertEquals(argProcessor.resolveOutputType(), OutputType.JSON);
    }

    @Test
    public void testResolveOutputTypeValidArguments_2() throws NoOutputTypeDefinedException {

        String[] args = {"xml", "json"};
        ArgProcessor argProcessor = new ArgumentProcessor(args);
        Assert.assertEquals(argProcessor.resolveOutputType(), OutputType.XML);
    }
}