package com.nnikolov.jiradump;

public class ErrorMessages {

    public static final String CODE_10001_NO_GRADLE_FILE_CONFIG = "[10001] Could not find gradle properties file to build environment configuration: %s";
    public static final String CODE_10002_CANT_LOAD_GRADLE_PROPS = "[10002] Could not load gradle properties as configuration";

    public static final String CODE_20001_COULD_NOT_WRITE_JSON_FILE = "[20001] Could not write file '%s.json'";
    public static final String CODE_20002_COULD_NOT_WRITE_XML_FILE = "[20002] Could not write file '%s.xml'";

    public static final String CODE_3001_INTERRUPT_ISSUES_DUMP_UNEXPECTED = "[30001] Interrupting JIRA issues dump because of unexpected error";
    public static final String CODE_3002_FETCH_ISSUE_CALL_FAILED = "[30002] Fetching issue call failed";
    public static final String CODE_3003_FETCH_ISSUE_CALL_FAILED = "[30003] Could not get next page of issues. Aborting...";
    public static final String CODE_3004_PARSE_ISSUE_FAILED = "[30004] Could not parse fetched issue";
    public static final String NO_OUTPUT_TYPE_DEFINED_DEFAULT = "There was no provided output type as argument";
}
