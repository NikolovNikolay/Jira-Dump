package com.nnikolov.jiradump.utils;

import java.io.File;

/**
 * Helper class for working with files
 */
public abstract class FileUtils {

    /**
     * Creates a directory
     *
     * @param dir the directory to create
     * @return true - if success
     */
    public static boolean createDirectory(File dir) {
        if (!(dir.exists() && dir.isDirectory())) {

            boolean created = dir.mkdirs();
            if (created) {
                System.out.println("Created directory: " + dir.getName());
            }
            return created;
        } else if (dir.exists() && dir.isDirectory()) {
            return true;
        }
        return false;
    }

    /**
     * Will create nested directories. If a directory can not be created then the
     * process will break.
     *
     * @param dirs directory names
     * @return path to the last created directory
     */
    public static File createSubDirectories(String... dirs) {
        System.out.println("Checking directories");
        File dir = null;
        for (String childName : dirs) {
            dir = new File(dir, childName);
            if (!createDirectory(dir)) {
                return dir;
            }
        }
        return dir;
    }
}
