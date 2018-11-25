package com.nnikolov.jiradump.env;

/**
 * Configuration source when persisting json files
 */
public final class JsonEnvironmentConfiguration extends BaseEnvironmentConfiguration {

    public JsonEnvironmentConfiguration() {
        System.out.println("Initializing json persistence environment configuration");
    }

    public String getBaseOutputDirName() {
        return RuntimeConstants.BASE_OUTPUT_DIR_NAME;
    }

    public String getOutputDirName() {
        return RuntimeConstants.JSON_OUTPUT_DIR_NAME;
    }

    public String getOutputRoot() {
        return RuntimeConstants.OUTPUT_ROOT;
    }
}
