package com.nnikolov.jiradump.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Common environment configuration
 */
public abstract class BaseEnvironmentConfiguration implements EnvironmentConfiguration {

    private static Logger logger = LoggerFactory.getLogger(BaseEnvironmentConfiguration.class);

    // Name of gradle properties file. Not used, copied configurations to RuntimeConstants
    static String NAME_GRADLE_PROPERTIES = "gradle.properties";

    static String JIRA_API_URL_LATEST = "JIRA_API_URL_LATEST";
    static String JIRA_WEB_BROWSE_URL = "JIRA_WEB_BROWSE_URL";
    static String JIRA_ISSUES_JQL_RESOURCE_PATH = "JIRA_ISSUES_JQL_RESOURCE_PATH";

    Properties properties;

    BaseEnvironmentConfiguration() {
    }

    public String getLatestApiUrl() {
        return RuntimeConstants.JIRA_API_URL_LATEST;
    }

    public String getIssueTypeFilteredIssuesUrl() {
        return getLatestApiUrl() + RuntimeConstants.JIRA_ISSUES_JQL_RESOURCE_PATH;
    }

    public String getIssueTypeFilteredIssuesUrl(int startAt, int maxResults) {
        return getIssueTypeFilteredIssuesUrl() + String.format("&startAt=%d&maxResults=%d", startAt, maxResults);
    }

    public String getWebBrowseBaseUrl() {
        return RuntimeConstants.JIRA_WEB_BROWSE_URL;
    }
}
