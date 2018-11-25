package com.nnikolov.jiradump.env;

/**
 * Configuration source when persisting xml files
 */
public class XmlEnvironmentConfiguration extends BaseEnvironmentConfiguration {

    public XmlEnvironmentConfiguration() {
        System.out.println("Initializing xml persistence environment configuration");
    }

    public String getBaseOutputDirName() {
        return RuntimeConstants.BASE_OUTPUT_DIR_NAME;
    }

    public String getOutputDirName() {
        return RuntimeConstants.XML_OUTPUT_DIR_NAME;
    }

    public String getOutputRoot() {
        return RuntimeConstants.OUTPUT_ROOT;
    }
}
