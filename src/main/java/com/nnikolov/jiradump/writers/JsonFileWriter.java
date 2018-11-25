package com.nnikolov.jiradump.writers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nnikolov.jiradump.env.EnvironmentConfiguration;
import com.nnikolov.jiradump.utils.DateUtils;
import com.nnikolov.jiradump.utils.FileUtils;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

import static com.nnikolov.jiradump.exception.ExceptionMessages.CODE_20001_COULD_NOT_WRITE_JSON_FILE;

/**
 * Writes object to file as a prettified json.
 */
public class JsonFileWriter implements Writer {

    private final static String EXTENSION = ".json";

    private final File writePath;
    private final ObjectWriter writer;
    private final String outputDir;

    @Inject
    public JsonFileWriter(EnvironmentConfiguration environmentConfiguration) {
        this.outputDir = environmentConfiguration.getBaseOutputDirName() + ("_" + DateUtils.stringifyStartOfWeek());
        this.writePath = FileUtils.createSubDirectories(outputDir, environmentConfiguration.getOutputDirName());
        ObjectMapper mapper = new ObjectMapper();
        this.writer = mapper.writerWithDefaultPrettyPrinter();
        System.out.println("Initializing json file writer");
    }

    @Override
    public File write(String fileName, Class<?> contentType, Object content) {
        try {
            File toWrite = new File(writePath, fileName + getExtension());
            writer.writeValue(toWrite, content);
            return toWrite;
        } catch (IOException e) {
            System.out.println(String.format(CODE_20001_COULD_NOT_WRITE_JSON_FILE, fileName));
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getExtension() {
        return EXTENSION;
    }

    @Override
    public String getOutputDirPath() {
        return outputDir;
    }
}
