package com.nnikolov.jiradump.env;

import com.nnikolov.jiradump.RuntimeConstants;

public class XmlEnvironmentConfiguration extends BaseEnvironmentConfiguration {

    private static String OUTPUT_DIR_NAME = "XML_OUTPUT_DIR_NAME";
    private static String OUTPUT_ROOT = "OUTPUT_ROOT";
    private static String BASE_OUTPUT_DIR_NAME = "BASE_OUTPUT_DIR_NAME";

    public XmlEnvironmentConfiguration() {
        System.out.println("Initializing json persistence environment configuration");
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
