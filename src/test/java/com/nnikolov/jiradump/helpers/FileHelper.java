package com.nnikolov.jiradump.helpers;

import com.nnikolov.jiradump.writers.Writer;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.rules.TemporaryFolder;

import javax.naming.OperationNotSupportedException;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.UUID;

import static com.nnikolov.jiradump.helpers.EntityHelper.buildEntity;

public class FileHelper {

    public static void testEntityContent(int iterationCount, TemporaryFolder tempFolder, Writer writer, Class<?> type)
            throws IOException, JAXBException, OperationNotSupportedException {

        EntityParser parser = new EntityParser(writer, type);
        for (int i = 0; i < iterationCount; i++) {
            // Build an issue
            Object issue = buildEntity(type);

            // Persist the issue in the original output dir
            String uuidName = UUID.randomUUID().toString();
            File originFile = writer.write(uuidName, type, issue);

            // Create a file in the temp directory to copy the origin's source
            File tempFile = copyOriginFile(tempFolder, originFile, uuidName);
            originFile.delete();

            // Map the content to object instance
            Object producedIssue = parser.parse(tempFile);
            tempFile = null;

            // Assert the result
            Assert.assertEquals(issue, producedIssue);
        }
    }

    public static File copyOriginFile(TemporaryFolder tempFolder, File originFile, String fileName) throws IOException {

        // Create a file in the temp directory to copy the origin's source
        File tempFile = tempFolder.newFile(fileName);

        // Read the original and write to temp
        try (InputStream inputStream = new FileInputStream(originFile)) {
            byte[] bytes = IOUtils.toByteArray(inputStream);
            try (OutputStream out = new FileOutputStream(tempFile)) {
                out.write(bytes);
            }
        }

        // byte[] buffer = new byte[255];
        // try (InputStream in = new FileInputStream(originFile)) {
        //     try (OutputStream out = new FileOutputStream(tempFile)) {
        //         while (in.read(buffer) > -1) {
        //             out.write(buffer);
        //         }
        //     }
        // }
        // buffer = null;

        return tempFile;
    }

    public static void cleanUp(TemporaryFolder tempFolder, Writer writer) throws IOException {

        tempFolder.delete();

        // Get main output directory
        File f = new File(writer.getOutputDirPath());
        deleteDirCascade(f);

        // Delete main output directory at the end
        f.delete();
    }

    private static void deleteDirCascade(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        } else if (file.exists() && file.isDirectory()) {
            try {
                // Delete all file within the main output directory
                for (File f : file.listFiles()) {
                    deleteDirCascade(f);
                }
                file.delete();
            } catch (NullPointerException ignored) {
            }
        }
    }
}
