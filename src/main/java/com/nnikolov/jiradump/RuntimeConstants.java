package com.nnikolov.jiradump;

public abstract class RuntimeConstants {

    private RuntimeConstants() {
    }

    public static String JIRA_API_URL_LATEST = "https://jira.atlassian.com/rest/api/2";
    public static String JIRA_ISSUES_JQL_RESOURCE_PATH = "/search?jql=issuetype%20in(Bug,%20Documentation,%20Enhancement)%20and%20updated%20%3E%20startOfWeek()";
    public static String JIRA_WEB_BROWSE_URL = "https://jira.atlassian.com/browse/";

    public static String BASE_OUTPUT_DIR_NAME = "Jira_Issues_Dump";
    public static String JSON_OUTPUT_DIR_NAME = "json";
    public static String XML_OUTPUT_DIR_NAME = "xml";
    public static String OUTPUT_ROOT = "";
}
