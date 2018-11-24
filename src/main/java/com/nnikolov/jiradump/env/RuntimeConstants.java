package com.nnikolov.jiradump.env;

/**
 * API communication constants and file output settings
 */
abstract class RuntimeConstants {

    // API communication
    static String JIRA_API_URL_LATEST = "https://jira.atlassian.com/rest/api/2";
    static String JIRA_ISSUES_JQL_RESOURCE_PATH = "/search?jql=issuetype%20in(Bug,%20Documentation,%20Enhancement)%20and%20updated%20%3E%20startOfWeek()";
    static String JIRA_WEB_BROWSE_URL = "https://jira.atlassian.com/browse/";
    static String BASE_OUTPUT_DIR_NAME = "Jira_Issues_Dump";

    // Output
    static String JSON_OUTPUT_DIR_NAME = "json";
    static String XML_OUTPUT_DIR_NAME = "xml";
    static String OUTPUT_ROOT = "";

    private RuntimeConstants() {
    }
}
