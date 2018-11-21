package com.nnikolov.jiradump;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.nnikolov.jiradump.ErrorMessages.CODE_10001_NO_GRADLE_FILE_CONFIG;
import static com.nnikolov.jiradump.ErrorMessages.CODE_10002_CANT_LOAD_GRADLE_PROPS;

public final class EnvConfig implements EnvironmentConfiguration {

    private static Logger logger = LoggerFactory.getLogger(EnvConfig.class);

    public static String NAME_GRADLE_PROPERTIES = "gradle.properties";
    public static String JIRA_API_URL_LATEST = "JIRA_API_URL_LATEST";
    public static String JIRA_ISSUES_JQL_RESOURCE_PATH = "JIRA_ISSUES_JQL_RESOURCE_PATH";
    public static String JIRA_WEB_BROWSE_URL = "JIRA_WEB_BROWSE_URL";
    public static String XML_OUTPUT_DIR_NAME = "XML_OUTPUT_DIR_NAME";
    public static String JSON_OUTPUT_DIR_NAME = "JSON_OUTPUT_DIR_NAME";
    public static String OUTPUT_ROOT = "OUTPUT_ROOT";

    public static String BASE_OUTPUT_DIR_NAME = "BASE_OUTPUT_DIR_NAME";

    Properties properties;

    private EnvConfig() {

        try {
            properties = new Properties();
            InputStream gradleInput = new FileInputStream(NAME_GRADLE_PROPERTIES);
            properties.load(gradleInput);
        } catch (FileNotFoundException e) {
            logger.error(String.format(CODE_10001_NO_GRADLE_FILE_CONFIG, NAME_GRADLE_PROPERTIES));
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(CODE_10002_CANT_LOAD_GRADLE_PROPS);
        }
    }

    private static class InternalHolder {
        private static final EnvConfig INSTANCE = new EnvConfig();
    }

    public static EnvConfig get() {
        return InternalHolder.INSTANCE;
    }

    public String getLatestApiUrl() {
        return properties.getProperty(JIRA_API_URL_LATEST);
    }

    public String getIssueTypeFilteredIssuesUrl(int startAt, int maxResults) {
        return getLatestApiUrl() + properties.getProperty(JIRA_ISSUES_JQL_RESOURCE_PATH);
    }

    public String getWebBrowseBaseUrl() {
        return properties.getProperty(JIRA_WEB_BROWSE_URL);
    }

    public String getBaseOutputDirName() {
        return properties.getProperty(BASE_OUTPUT_DIR_NAME);
    }

    public String getXmlOutputDirName() {
        return properties.getProperty(XML_OUTPUT_DIR_NAME);
    }

    public String getJsonOutputDirName() {
        return properties.getProperty(JSON_OUTPUT_DIR_NAME);
    }

    public String getOutputRoot() {
        return properties.getProperty(OUTPUT_ROOT);
    }
}