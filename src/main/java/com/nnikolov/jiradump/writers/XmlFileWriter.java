package com.nnikolov.jiradump.writers;

import com.nnikolov.jiradump.env.EnvironmentConfiguration;
import com.nnikolov.jiradump.utils.DateUtils;
import com.nnikolov.jiradump.utils.FileUtils;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/**
 * Writes object to file as a prettified xml.
 */
public class XmlFileWriter implements Writer {

    private final static String EXTENSION = ".xml";
    private final File writePath;

    @Inject
    public XmlFileWriter(EnvironmentConfiguration environmentConfiguration) {
        String outputDir = environmentConfiguration.getBaseOutputDirName() + ("_" + DateUtils.stringifyStartOfWeek());
        this.writePath = FileUtils.createSubDirs(outputDir, environmentConfiguration.getOutputDirName());
        System.out.println("Initializing xml file writer");
    }

    @Override
    public void write(String fileName, Class<?> contentType, Object content) {
        try {
            JAXBContext context = JAXBContext.newInstance(contentType);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(content, sw);
            String xmlString = sw.toString();
            File newIssue = new File(writePath, fileName + EXTENSION);

            try (OutputStream outputStream = new FileOutputStream(newIssue)) {
                outputStream.write(xmlString.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
