package com.nnikolov.jiradump.writers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nnikolov.jiradump.utils.DateUtils;
import com.nnikolov.jiradump.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static com.nnikolov.jiradump.ErrorMessages.CODE_20001_COULD_NOT_WRITE_JSON_FILE;

public class JsonFileWriter implements Writer {

    private final Logger logger = LoggerFactory.getLogger(JsonFileWriter.class);

    private final static String EXTENSION = ".json";

    private final File writePath;
    private final ObjectMapper mapper;
    private final ObjectWriter writer;

    public JsonFileWriter(String root, String baseOutputDirName, String jsonDirName) {
        baseOutputDirName += ("_" + DateUtils.stringifyStartOfWeek());
        this.writePath = FileUtils.createSubDirs(baseOutputDirName, jsonDirName);
        this.mapper = new ObjectMapper();
        this.writer = mapper.writerWithDefaultPrettyPrinter();
    }

    @Override
    public void write(String fileName, Object content) {

        try {
            writer.writeValue(new File(writePath, fileName + EXTENSION), content);
        } catch (IOException e) {
            logger.error(String.format(CODE_20001_COULD_NOT_WRITE_JSON_FILE, fileName));
            e.printStackTrace();
        }
    }
}
