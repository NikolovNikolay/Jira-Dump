package com.nnikolov.jiradump.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnikolov.jiradump.writers.JsonFileWriter;
import com.nnikolov.jiradump.writers.Writer;
import com.nnikolov.jiradump.writers.XmlFileWriter;

import javax.naming.OperationNotSupportedException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class EntityParser {

    private Unmarshaller unmarshaller;
    private Writer writer;
    private Class<?> type;
    private ObjectMapper mapper;

    public EntityParser(Writer writer, Class<?> type) throws JAXBException {
        this.writer = writer;
        this.type = type;
        if (writer instanceof JsonFileWriter) {
            mapper = new ObjectMapper();
        } else if (writer instanceof XmlFileWriter) {
            JAXBContext context = JAXBContext.newInstance(type);
            this.unmarshaller = context.createUnmarshaller();
        }
    }

    public Object parse(File file) throws JAXBException, OperationNotSupportedException, IOException {
        if (writer instanceof JsonFileWriter) {
            return mapper.readValue(file, type);
        } else if (writer instanceof XmlFileWriter) {
            return unmarshaller.unmarshal(file);
        } else {
            throw new OperationNotSupportedException();
        }
    }
}
