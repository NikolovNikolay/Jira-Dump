package com.nnikolov.jiradump.utils;

import java.io.File;

public abstract class FileUtils {

    public static boolean createDirctory(File dir) {
        if (!(dir.exists() && dir.isDirectory())) {
            return dir.mkdirs();
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
    public static File createSubDirs(String... dirs) {

        File dir = null;
        for (String childName : dirs) {
            dir = new File(dir, childName);
            if (!createDirctory(dir)) {
                return dir;
            }
        }
        return dir;
    }

}
