package com.nnikolov.jiradump;

public interface EnvironmentConfiguration {

    String getLatestApiUrl();

    String getIssueTypeFilteredIssuesUrl(int startAt, int maxResults);
}
