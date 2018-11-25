package com.nnikolov.jiradump.env;

/**
 * Information to help persistence process - prepared API call
 * URLs and folder paths and names
 */
public interface EnvironmentConfiguration extends ApiInfo {

    /**
     * @return absolute path to root directory. By default the root is
     * the place of execution.
     */
    String getOutputRoot();

    /**
     * @return content directory name within the root
     */
    String getBaseOutputDirName();

    /**
     * @return folder name to persist the downloaded files
     */
    String getOutputDirName();
}
