package com.nnikolov.jiradump.writers;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nnikolov.jiradump.env.EnvironmentConfiguration;
import com.nnikolov.jiradump.guice.InjectorService;
import com.nnikolov.jiradump.guice.JsonIssueDumpModule;
import com.nnikolov.jiradump.helpers.FileHelper;
import com.nnikolov.jiradump.model.Issue;
import com.nnikolov.jiradump.model.IssuePriority;
import com.nnikolov.jiradump.model.IssueType;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.naming.OperationNotSupportedException;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

import static com.nnikolov.jiradump.helpers.FileHelper.testEntityContent;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JsonFileWriterTest {

    static final int ITERATION_COUNT = 5;
    private Gson gson;
    private Writer writer;
    private EnvironmentConfiguration envConfig;

    @Rule
    public TemporaryFolder tempFolder;

    @Mock
    InjectorService injectorService;

    @Test
    public void testWriteIssueAccuracy() throws IOException, JAXBException, OperationNotSupportedException {
        testEntityContent(ITERATION_COUNT, tempFolder, writer, Issue.class);
    }

    @Test
    public void testWriteIssueTypeAccuracy() throws IOException, JAXBException, OperationNotSupportedException {
        testEntityContent(ITERATION_COUNT, tempFolder, writer, IssueType.class);
    }

    @Test
    public void testWriteIssuePriorityAccuracy() throws IOException, JAXBException, OperationNotSupportedException {
        testEntityContent(ITERATION_COUNT, tempFolder, writer, IssuePriority.class);
    }

    @Before
    public void prepareComponents() throws IOException {
        when(injectorService.produceInjector())
                .thenReturn(Guice.createInjector(new JsonIssueDumpModule()));

        Injector injector = injectorService.produceInjector();
        gson = injector.getInstance(Gson.class);
        envConfig = injector.getInstance(EnvironmentConfiguration.class);
        writer = injector.getInstance(Writer.class);

        tempFolder = new TemporaryFolder(new File(writer.getOutputDirPath()));
        tempFolder.create();
    }

    @After
    public void cleanUp() throws IOException {
        // Clean-up

        // Delete temporary folder
        FileHelper.cleanUp(tempFolder, writer);
    }
}