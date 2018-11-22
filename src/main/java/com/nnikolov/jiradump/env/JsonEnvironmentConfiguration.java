package com.nnikolov.jiradump.env;

/**
 * Information for persisting json files
 */
public final class JsonEnvironmentConfiguration extends BaseEnvironmentConfiguration {

    private static String OUTPUT_DIR_NAME = "JSON_OUTPUT_DIR_NAME";
    private static String OUTPUT_ROOT = "OUTPUT_ROOT";
    private static String BASE_OUTPUT_DIR_NAME = "BASE_OUTPUT_DIR_NAME";

    public JsonEnvironmentConfiguration() {
        System.out.println("Initializing json persistence environment configuration");
    }

    public String getBaseOutputDirName() {
        return properties.getProperty(BASE_OUTPUT_DIR_NAME);
    }

    public String getOutputDirName() {
        return properties.getProperty(OUTPUT_DIR_NAME);
    }

    public String getOutputRoot() {
        return properties.getProperty(OUTPUT_ROOT);
    }
}
