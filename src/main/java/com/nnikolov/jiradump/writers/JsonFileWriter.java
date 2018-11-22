package com.nnikolov.jiradump.writers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nnikolov.jiradump.env.EnvironmentConfiguration;
import com.nnikolov.jiradump.utils.DateUtils;
import com.nnikolov.jiradump.utils.FileUtils;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

import static com.nnikolov.jiradump.ErrorMessages.CODE_20001_COULD_NOT_WRITE_JSON_FILE;

/**
 * Writes object to file as a prettified json.
 */
public class JsonFileWriter implements Writer {

    private final static String EXTENSION = ".json";

    private final File writePath;
    private final ObjectWriter writer;

    @Inject
    public JsonFileWriter(EnvironmentConfiguration environmentConfiguration) {
        String outputDir = environmentConfiguration.getBaseOutputDirName() + ("_" + DateUtils.stringifyStartOfWeek());
        this.writePath = FileUtils.createSubDirs(outputDir, environmentConfiguration.getOutputDirName());
        ObjectMapper mapper = new ObjectMapper();
        this.writer = mapper.writerWithDefaultPrettyPrinter();
        System.out.println("Initializing json file writer");
    }

    @Override
    public void write(String fileName, Class<?> contentType, Object content) {

        try {
            writer.writeValue(new File(writePath, fileName + EXTENSION), content);
        } catch (IOException e) {
            System.out.println(String.format(CODE_20001_COULD_NOT_WRITE_JSON_FILE, fileName));
            e.printStackTrace();
        }
    }
}
