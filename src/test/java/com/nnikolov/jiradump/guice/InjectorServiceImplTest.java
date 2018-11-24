package com.nnikolov.jiradump.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.nnikolov.jiradump.ArgProcessor;
import com.nnikolov.jiradump.enums.OutputType;
import com.nnikolov.jiradump.exception.NoOutputTypeDefinedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InjectorServiceImplTest {

    @Mock
    ArgProcessor argProcessor;

    @InjectMocks
    InjectorServiceImpl injectorService;

    @Test
    public void testProduceModuleNoOutputDefined() throws NoOutputTypeDefinedException {
        when(argProcessor.resolveOutputType()).thenThrow(NoOutputTypeDefinedException.class);
        AbstractModule module = injectorService.produceModule();
        assertNotNull(module);
        assertEquals(module.getClass(), XmlIssueDumpModule.class);
    }

    @Test(expected = NullPointerException.class)
    public void testProduceModuleNoArgumentProcessor() throws NoOutputTypeDefinedException {
        when(argProcessor.resolveOutputType()).thenThrow(NullPointerException.class);
        injectorService.produceModule();
    }

    @Test
    public void testProduceModuleJsonModule() throws NoOutputTypeDefinedException {
        when(argProcessor.resolveOutputType()).thenReturn(OutputType.JSON);
        AbstractModule module = injectorService.produceModule();
        assertNotNull(module);
        assertEquals(module.getClass(), JsonIssueDumpModule.class);
    }

    @Test
    public void testProduceModuleXmlModule() throws NoOutputTypeDefinedException {
        when(argProcessor.resolveOutputType()).thenReturn(OutputType.XML);
        AbstractModule module = injectorService.produceModule();
        assertNotNull(module);
        assertEquals(module.getClass(), XmlIssueDumpModule.class);
    }

    @Test
    public void testProduceInjector() throws NoOutputTypeDefinedException {

        when(argProcessor.resolveOutputType()).thenThrow(NoOutputTypeDefinedException.class);
        Injector injector = injectorService.produceInjector();
        assertNotNull(injector);
    }
}