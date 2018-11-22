package com.nnikolov.jiradump.env;

/**
 * Information to help persistence process - prepared API call
 * URLs and folder paths and names
 */
public interface EnvironmentConfiguration extends ApiInfoHolder {

    /**
     * @return absolute path to root directory. By default the root is
     * the place of execution.
     */
    String getOutputRoot();

    /**
     * @return content directory name in the direct root
     */
    String getBaseOutputDirName();

    /**
     * @return folder to hold the persisted files
     */
    String getOutputDirName();
}
