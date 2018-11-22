package com.nnikolov.jiradump.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.nnikolov.jiradump.ErrorMessages.CODE_10001_NO_GRADLE_FILE_CONFIG;
import static com.nnikolov.jiradump.ErrorMessages.CODE_10002_CANT_LOAD_GRADLE_PROPS;

/**
 * Common environment configuration
 */
public abstract class BaseEnvironmentConfiguration implements EnvironmentConfiguration {

    private static Logger logger = LoggerFactory.getLogger(BaseEnvironmentConfiguration.class);

    // Name of gradle props file
    static String NAME_GRADLE_PROPERTIES = "gradle.properties";

    static String JIRA_API_URL_LATEST = "JIRA_API_URL_LATEST";
    static String JIRA_WEB_BROWSE_URL = "JIRA_WEB_BROWSE_URL";
    static String JIRA_ISSUES_JQL_RESOURCE_PATH = "JIRA_ISSUES_JQL_RESOURCE_PATH";

    Properties properties;

    BaseEnvironmentConfiguration() {
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

    public String getLatestApiUrl() {
        return properties.getProperty(JIRA_API_URL_LATEST);
    }

    public String getIssueTypeFilteredIssuesUrl() {
        return getLatestApiUrl() + properties.getProperty(JIRA_ISSUES_JQL_RESOURCE_PATH);
    }

    public String getIssueTypeFilteredIssuesUrl(int startAt, int maxResults) {
        return getIssueTypeFilteredIssuesUrl() + String.format("&startAt=%d&maxResults=%d", startAt, maxResults);
    }

    public String getWebBrowseBaseUrl() {
        return properties.getProperty(JIRA_WEB_BROWSE_URL);
    }
}
